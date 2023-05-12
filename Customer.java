public class Customer {
    private String name;        // Name of the customer
    private String email;       // Email address of the customer
    private String password;    // Password of the customer's account
    private String address;     // Address of the customer
    private int loyaltyPoints;  // Loyalty points accumulated by the customer

    public Customer(String name, String email, String password, String address) {
        // Constructor to initialize the customer object
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.loyaltyPoints = 0;  // Initially, the customer has 0 loyalty points
    }

    public String getName() {
        // Getter method for the name attribute
        return name;
    }

    public String getEmail() {
        // Getter method for the email attribute
        return email;
    }

    public String getPassword() {
        // Getter method for the password attribute
        return password;
    }

    public String getAddress() {
        // Getter method for the address attribute
        return address;
    }

    public int getLoyaltyPoints() {
        // Getter method for the loyaltyPoints attribute
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        // Method to add loyalty points to the customer's account
        loyaltyPoints += points;
    }
}
