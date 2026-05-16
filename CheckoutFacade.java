public class CheckoutFacade {
    private Inventory inventory;
    private Payment payment;
    private Shipping shipping;
    private Email email;
    private TaxCalculator taxCalculator;
    private Logger logger;

    public CheckoutFacade() {
        this.inventory = new Inventory();
        this.payment = new Payment();
        this.shipping = new Shipping();
        this.email = new Email();
        this.taxCalculator = new TaxCalculator();
        this.logger = new Logger();
    }

    public OrderResult checkout(String userId, String productId, double price, String address) {
        boolean  success = false;

        try {
            String state = address.length() >= 2 ? address.substring(address.length() - 2) : "Not Known";
            double tax = taxCalculator.Tax(price, state);
            double totalPrice = price + tax;


            if (!inventory.checkStock(productId)) {
               return new OrderResult(false, null, "Item out of stock");
            }

            inventory.reserve(productId);

           if (!payment.charge(userId, totalPrice)) {
               inventory.release(productId);
               return new OrderResult(false, null, "Payment failed");
            }

           if (!shipping.isAvailable()) {
               payment.refund(userId, totalPrice);
               inventory.release(productId);
               return new OrderResult(false, null, "Shipping failed");
            }

            String tracking = shipping.createLabel(address);
            shipping.schedulePickup(tracking);

            email.send(userId, "Order Confirmed", "Total:  N " + totalPrice + " (Tax:  N " + tax + "). Your tracking number is: " + tracking);

            success = true;
            return new OrderResult(true, tracking, "Order placed successfully");
        } finally {
            logger.log(userId, success);
        }

    }

    public static void main(String[] args) {
        CheckoutFacade retail = new CheckoutFacade();
        OrderResult result = retail.checkout("user123", "LAPTOP-001", 1200.00, "123 Java Lane");

        System.out.println("Message: " + result.getMessage());
    }

    class OrderResult {
        private final boolean success;
        private final String trackingNumber;
        private final String message;

        public OrderResult(boolean success, String trackingNumber, String message) {
            this.success = success;
            this.trackingNumber = trackingNumber;
            this.message = message;
        }

        public boolean isSuccess() { return success; }
        public String getTrackingNumber() { return trackingNumber; }
        public String getMessage() { return message; }
    }


}

class Inventory {
    boolean checkStock(String productId) { return true; }
    void reserve(String productId) { System.out.println("Reserved " + productId); }
    void release(String productId) { System.out.println("Released " + productId);}
}

class Payment {
    boolean charge(String userID, double amount) { return true; }
    void refund(String userID, double amount) { System.out.println("Refunded " + amount); }
}

class Shipping {
    String createLabel(String address) { return "TRK" + System.currentTimeMillis(); }
    void schedulePickup(String label) { System.out.println("Pickup scheduled for " + label); }
    boolean isAvailable() { return true; }
}

class Email {
    void send(String to, String subject, String body) { System.out.println("Email to " + to + " Subject: " + subject + " Body: " + body); }
}

class TaxCalculator {
    public double Tax(double price, String state) {
        if ("CA".equalsIgnoreCase(state)) {
            return price * 0.88;
        }
        return 0.0;
    }
}

class Logger {
    public void log(String userId, boolean success) {
        long timestamp = System.currentTimeMillis();
        String status = success ? "SUCCESS" : "FAILURE";
        System.out.println("[ LOG " + timestamp + " ] User: " + userId + " | Status: " + status);
    }
}