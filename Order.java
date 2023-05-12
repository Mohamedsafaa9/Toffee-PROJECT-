import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Item> items;
    private Date orderDate;
    private String shippingAddress;
    private String paymentMethod;
    private int loyaltyPointsUsed;
// Constructor for the Order class

    public Order(int orderId, Customer customer, List<Item> items, String shippingAddress, String paymentMethod, int loyaltyPointsUsed) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.orderDate = new Date();
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.loyaltyPointsUsed = loyaltyPointsUsed;
    }
// Getter method for orderId

    public int getOrderId() {
        return orderId;
    }
// Getter method for customer

    public Customer getCustomer() {
        return customer;
    }
// Getter method for items

    public List<Item> getItems() {
        return items;
    }
// Getter method for orderDate

    public Date getOrderDate() {
        return orderDate;
    }
// Getter method for shippingAddress

    public String getShippingAddress() {
        return shippingAddress;
    }
// Getter method for paymentMethod

    public String getPaymentMethod() {
        return paymentMethod;
    }
// Getter method for loyaltyPointsUsed

    public int getLoyaltyPointsUsed() {
        return loyaltyPointsUsed;
    }
}
