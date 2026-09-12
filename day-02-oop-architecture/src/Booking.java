public class Booking {

    private int bookingId;
    private Customer customer;
    private Service service;
    private String status;

    public Booking(int bookingId, Customer customer, Service service, String status) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.service = service;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Service getService() {
        return service;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void confirm() {
        status = "CONFIRMED";
    }

    public void cancel() {
        status = "CANCELLED";
    }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Service: " + service.getName());
        System.out.println("Price: " + service.getPrice());
        System.out.println("Status: " + status);
        System.out.println("---------------------------");
    }
}