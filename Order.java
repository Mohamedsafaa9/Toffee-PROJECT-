import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private LocalDateTime orderDateTime;
    private User user;
    private List<Item> items;
    private double totalAmount;
    private boolean paidOnDelivery;
    private boolean isClosed;

    /*
      Constructor for the Order class.
      orderId the unique identifier for the order.
      user the user who placed the order.
      items the list of items ordered in the order.
      totalAmount the total amount of the order.
      paidOnDelivery whether the order is to be paid on delivery.
     */
    public Order(int orderId, User user, List<Item> items, double totalAmount, boolean paidOnDelivery) {
        this.orderId = orderId;
        this.orderDateTime = LocalDateTime.now();
        this.user = user;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.paidOnDelivery = paidOnDelivery;
        this.isClosed = false;
    }

    // Getters and setters
    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public User getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaidOnDelivery() {
        return paidOnDelivery;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

// Other methods
    /*
      Adds an item to the order.
       item the item to be added.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /*
     * Removes an item from the order.
     *  item the item to be removed.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

}
