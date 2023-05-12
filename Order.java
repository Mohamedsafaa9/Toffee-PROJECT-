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

    public Order(int orderId, Customer customer, List<Item> items, String shippingAddress, String paymentMethod, int loyaltyPointsUsed) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.orderDate = new Date();
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.loyaltyPointsUsed = loyaltyPointsUsed;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public int getLoyaltyPointsUsed() {
        return loyaltyPointsUsed;
    }
}
