import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // -----------------------------------
        // 1. Create Customer objects
        // -----------------------------------

        Customer customer1 = new Customer(101, "Sarthak", "Premium");
        Customer customer2 = new Customer(102, "Rahul", "Regular");
        Customer customer3 = new Customer(103, "Omkar", "Regular");


        // -----------------------------------
        // 2. Create Service objects
        // -----------------------------------

        Service service1 = new Service(1, "Haircut", 300.0);
        Service service2 = new Service(2, "Massage", 800.0);
        Service service3 = new Service(3, "Consultation", 500.0);


        // -----------------------------------
        // 3. Create Booking objects
        // -----------------------------------

        Booking booking1 = new Booking(
                1001,
                customer1,
                service1,
                "CREATED"
        );

        Booking booking2 = new Booking(
                1002,
                customer2,
                service2,
                "CONFIRMED"
        );

        Booking booking3 = new Booking(
                1003,
                customer3,
                service3,
                "CREATED"
        );


        // -----------------------------------
        // 4. Demonstrate ArrayList
        // -----------------------------------

        ArrayList<Booking> bookings = new ArrayList<>();

        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);

        System.out.println("===== ALL BOOKINGS =====");

        for (Booking booking : bookings) {
            booking.displayBooking();
        }


        // -----------------------------------
        // 5. Demonstrate HashSet
        // -----------------------------------

        HashSet<String> serviceNames = new HashSet<>();

        serviceNames.add(service1.getName());
        serviceNames.add(service2.getName());
        serviceNames.add(service3.getName());

        // Adding duplicate service name
        serviceNames.add("Haircut");

        System.out.println("===== UNIQUE SERVICE NAMES =====");

        for (String serviceName : serviceNames) {
            System.out.println(serviceName);
        }


        // -----------------------------------
        // 6. Demonstrate HashMap
        // -----------------------------------

        HashMap<Integer, Booking> bookingById = new HashMap<>();

        bookingById.put(booking1.getBookingId(), booking1);
        bookingById.put(booking2.getBookingId(), booking2);
        bookingById.put(booking3.getBookingId(), booking3);

        System.out.println("\n===== BOOKING LOOKUP =====");

        int searchBookingId = 1002;

        Booking foundBooking = bookingById.get(searchBookingId);

        if (foundBooking != null) {
            foundBooking.displayBooking();
        } else {
            System.out.println("Booking not found.");
        }


        // -----------------------------------
        // 7. Demonstrate Polymorphism
        // -----------------------------------

        System.out.println("===== POLYMORPHISM =====");

        User user = new Customer(
                104,
                "Priya",
                "Premium"
        );

        user.displayInfo();


        // -----------------------------------
        // 8. Demonstrate Abstraction
        // -----------------------------------

        System.out.println("\n===== ABSTRACTION =====");

        NotificationService notification =
                new EmailNotification();

        notification.sendNotification(
                "Your booking has been confirmed."
        );
    }
}


// -----------------------------------
// Notification implementation
// -----------------------------------

class EmailNotification implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("Email Notification: " + message);
    }
}