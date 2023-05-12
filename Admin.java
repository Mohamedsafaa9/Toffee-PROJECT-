import java.util.List;

public class Admin {
    private String username;
    private String password;
    private LoyaltyPointsScheme loyaltyPointsScheme;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void viewOrders(List<Order> orders) {

        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public void setLoyaltyPointsScheme() {
        setLoyaltyPointsScheme(null);
    }

    public void setLoyaltyPointsScheme(LoyaltyPointsScheme scheme) {
        // Implement logic to set the loyalty points scheme
    }

    public void suspendUser(User user) {
        user.suspend();
    }
    }
