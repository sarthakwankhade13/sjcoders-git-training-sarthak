public class Customer extends User {

    private String customerType;

    public Customer(int id, String name, String customerType) {
        super(id, name);
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer ID: " + getId());
        System.out.println("Customer Name: " + getName());
        System.out.println("Customer Type: " + customerType);
    }
}