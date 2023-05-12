// This class represents a user in the system
public class User {
    // Instance variables for the user's email, password, address, and loyalty points
    private String email;
    private String password;
    private String address;
    private int loyaltyPoints;

    // Constructor that takes in the user's email, password, and address
    public User(String email, String password, String address) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.loyaltyPoints = 0; // Set the initial loyalty points to 0
    }

    // Getter method for the user's email
    public String getEmail() {
        return email;
    }

    // Getter method for the user's password
    public String getPassword() {
        return password;
    }

    // Getter method for the user's address
    public String getAddress() {
        return address;
    }

    // Getter method for the user's loyalty points
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Method to add loyalty points to the user's account
    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    // Method to authenticate the user by comparing the given password to the stored password
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
    }