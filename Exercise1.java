RoomService rooms = new RoomService();
PaymentService payment = new PaymentService();
LoyaltyPoints loyalty = new LoyaltyPoints();
EmailService email = new EmailService();

String guest = "john@example.com";
String roomType = "DELUXE";
double price = 250.00;

if (rooms.isAvailable(roomType)) {
    if (payment.charge(guest, price)) {
        rooms.book(roomType, guest);
        loyalty.addPoints(guest, (int)price);
        email.sendConfirmation(guest, roomType);
        System.out.println("Booking confirmed");
    } else {
            System.out.println("Payment declined");
        } 
} else {
        System.out.println("Room not available");
    } 
     

// The reasons this code needs facade include:
// 1. High Coupling with the different services.
// 2. Complex internal logic (business logic is being leaked into the UI)
// 3. Code Duplication and Maintenance.