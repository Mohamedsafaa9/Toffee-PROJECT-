public class User {
    private String email;
    private String password;
    private String address;
    private boolean isVerified;
// Define a constructor that takes in an email, password, and address

    // Define a constructor that takes in an email, password, and address
    public User(String email, String password, String address) {
        // Set the email, password, and address fields
        this.email = email;
        this.password = password;
        this.address = address;
        // Set the verification status to false by default
        this.isVerified = false;
    }

    // Define a getter method for the email field
    public String getEmail() {
        return email;
    }

    // Define a setter method for the email field
    public void setEmail(String email) {
        this.email = email;
    }

    // Define a getter method for the password field
    public String getPassword() {
        return password;
    }

    // Define a setter method for the password field
    public void setPassword(String password) {
        this.password = password;
    }

    // Define a getter method for the address field
    public String getAddress() {
        return address;
    }

    // Define a setter method for the address field
    public void setAddress(String address) {
        this.address = address;
    }

    // Define a getter method for the verification status field
    public boolean isVerified() {
        return isVerified;
    }

    // Define a setter method for the verification status field
    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
}