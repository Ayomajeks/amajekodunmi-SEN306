public class LegacyOrderFacade {
   private LegacyOrderProcessor legacyProcessor;

   public LegacyOrderFacade() {
      this.legacyProcessor = new LegacyOrderProcessor();
    }

   public void placeOrder(String email, String item, double price, String address) {
      System.out.println("---- Starting Order ----");

      legacyProcessor.processOrder(email, item, price, address);
    }

    public static void main(String[] args) {
        LegacyOrderFacade facade = new LegacyOrderFacade();

        facade.placeOrder("aymajek@gmail.com", "SNEAKER-99", 5000.00, "456 Oak Road");
    }
}