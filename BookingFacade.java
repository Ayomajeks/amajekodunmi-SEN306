public class BookingFacade {
    private RoomService rooms;
    private PaymentService payment;
    private LoyaltyPoints loyalty;
    private EmailService email;

    public BookingFacade() {
        this.rooms = new RoomService();
        this.payment = new PaymentService();
        this.loyalty = new LoyaltyPoints();
        this.email = new EmailService();
    }

    public static void main(String[] args) {
        BookingFacade hotelFacade = new BookingFacade();

        boolean success = hotelFacade.bookRoom("john@example.com", "DELUXE", 250.00);

        if (success) {
            System.out.println("Booking process successfully");
        } else {
            System.out.println("Booking failed");
        }
    }

    public boolean bookRoom(String guest, String roomType, double price) {
        if (!rooms.isAvailable(roomType)) return false;
        if (!payment.charge(guest, price)) return false;

        rooms.book(roomType, guest);
        loyalty.addPoints(guest, (int)price);
        email.sendConfirmation(guest, roomType);
        return true;
    }
}

class RoomService {
    public boolean isAvailable(String type) { return true; }
    public void book(String type, String guest) { System.out.println("Room booked."); }
}

class PaymentService {
    public boolean charge(String guest, double amount) { System.out.println("Charged " + guest + " amount " + amount); return true; }
}

class LoyaltyPoints {
    public void addPoints(String guest, int points) { System.out.println("Points added."); }
}

class EmailService {
    public void sendConfirmation(String guest, String type) { System.out.println("Email sent."); }
}