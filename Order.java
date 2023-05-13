import java.util.ArrayList;

/*
 * The Order class represents an order made by a customer.
 */
public class Order {
    private ArrayList<Item> items;
    private boolean isPaid;
    private boolean isDelivered;

    /*
      Constructs a new Order object with an empty list of items.
     */
    public Order() {
        items = new ArrayList<Item>();
        isPaid = false;
        isDelivered = false;
    }

    /*
     * Adds an item to the order.
       The item to add.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /*
     * Calculates the total price of all items in the order.
     * return The total price of the order.
     */
    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    /*
     * Marks the order as paid.
     */
    public void markAsPaid() {
        isPaid = true;
    }

    /*
     * Marks the order as delivered.
     */
    public void markAsDelivered() {
        isDelivered = true;
    }

    /*
     * true if the order has been paid for.
     True if the order has been paid for, false otherwise.
     */
    public boolean isPaid() {
        return isPaid;
    }

    /*
      Returns true if the order has been delivered.
      return True if the order has been delivered, false otherwise.
     */
    public boolean isDelivered() {
        return isDelivered;
    }
}
