public class User {
    private String email;
    private String password;
    private String address;
    private int loyaltyPoints;

    public User(String email, String password, String address) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.loyaltyPoints = 0;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void suspend() {
    }
}
