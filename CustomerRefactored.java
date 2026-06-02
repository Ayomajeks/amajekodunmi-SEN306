import java.util.Arrays;

class Customer {
    String name;
    String address;
    int customerType;
    String email;
    boolean isVip;
    
    public Customer(String name, String address, int customerType, String email, boolean isVip) {
        this.name = name;
        this.address = address;
        this.customerType = customerType;
        this.email = email;
        this.isVip = isVip;
    }
}

public class CustomerRefactored {
    private static void sendEmail(String email, String message) {
        System.out.println("[SMTP Log] Email dispatched to " + email);
    }

    public static double orderSum(double[] orders, int count) {
        if (orders == null || count < 0 || count > orders.length) {
            throw new IllegalArgumentException("Invalid order count.");
        }
        
        double sum = 0;
        for (int i = 0; i < count; i++) {
            if (orders[i] < 0) {
                throw new IllegalArgumentException("Negative order values are prohibited.");
            }
            sum += orders[i];
        }
        return sum;
    }

    public static double discountRate(int customerType) {
        if (customerType == 1) return 0.1;
        if (customerType == 2) return 0.2;
        if (customerType == 0) return 0.0;

        throw new IllegalArgumentException("Unrecognized customer category tier provided.");
    }

    public static String statusMessage(Customer customer, double total) {
        String msg = "Hello " + customer.name + " of " + customer.address + ", your total is " + total;
        if (customer.isVip) {
            msg += " (VIP)";
        }
        return msg;
    }

    public static void dispatchNotification(String email, String message) {
        if (email != null && !email.trim().isEmpty()) {
            sendEmail(email, message);
        }
    }

    public static double processCustomer(Customer customer, double[] orders, int orderCount) {
        double subTotal = orderSum(orders, orderCount);
        double discount = discountRate(customer.customerType);
        double finalTotal = subTotal - (subTotal * discount);

        String notificationText = statusMessage(customer, finalTotal);
        System.out.println(notificationText);
        dispatchNotification(customer.email, notificationText);

        return finalTotal;
    }

    public static void main(String[] args) { //Initialization 
        Customer sampleUser = new Customer("Ayomipo", "Lagos, Nigeria", 2, "ayomipo@example.com", true);
        double[] userHistory = {150.0, 50.0, 100.0};
        
        double processedTotal = processCustomer(sampleUser, userHistory, 3);
    }
}

