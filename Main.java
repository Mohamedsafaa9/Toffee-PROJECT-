import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a new user
        User user = new User(2,"John", "Doe", "johndoe@gmail.com","ewrfew");

        // Create some items
        Item item1 = new Item("Chocolate Chip Cookies", "Desserts", "Soft and chewy cookies with chocolate chips","Chips Ahoy",3.49,0.00);
        Item item2 = new Item("Milk Chocolate", "Candy", "Sweet milk chocolate covered toffee bits,Mackinac Fudge Shop","Mackinac Fudge Sho",5.99,0.03);
        Item item3 = new Item("Dark Chocolate", "Toffee,", " Rich dark chocolate covered toffee","Candy",12.99,0.16);

        // Create an order
        List<Item> items = new ArrayList<>(); // Create an empty list to hold the order items
        items.add(item1); // Add the first item to the list
        items.add(item2); // Add the second item to the list
        Order order = new Order(1, user, items, 30.0, false); // Create the order with the user, items, and total amount

        // Add another item to the order
        order.addItem(item3);

        // Remove an item from the order
        order.removeItem(item2);

        // Print the order details
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Order Date and Time: " + order.getOrderDateTime());
        System.out.println("User: " + order.getUser().getFirstName() + " " + order.getUser().getLastName());
        System.out.println("Items:");
        for (Item item : order.getItems()) { // Loop through the items in the order and print their names and prices
            System.out.println("- " + item.getName() + " (" + item.getPrice() + ")");
        }
        System.out.println("Total Amount: " + order.getTotalAmount()); // Print the total amount of the order
        System.out.println("Paid On Delivery: " + order.isPaidOnDelivery()); // Print whether the order is paid on delivery or not
        System.out.println("Order Status: " + OrderStatus.NEW); // Print the order status
        System.out.println("Payment Method: " + PaymentMethod.CREDIT_CARD); // Print the payment method
    }
}
