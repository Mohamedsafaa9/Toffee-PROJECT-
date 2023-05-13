import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        boolean isDone = false;
        String PaymentMethod = "cash"; // declare and initialize PaymentMethod

        // Loop to read item names from user input
        while (!isDone) {
            System.out.print("Enter item name (or 'done' to finish order): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                isDone = true;
                continue;
            }
            double itemPrice = 0.0;
            boolean itemFound = false;
            try {
                // Read item prices from file and find the price of the entered item
                Scanner fileScanner = new Scanner(new File("C:\\Users\\Lenovo\\OneDrive - Cairo University - Students\\Desktop\\New folder (2)\\m4\\item.txt"));
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts[0].equalsIgnoreCase(itemName)) {
                        itemPrice = Double.parseDouble(parts[1]);
                        itemFound = true;
                        break;
                    }
                }
                fileScanner.close();
                // Display error message if the item was not found in the file
                if (!itemFound) {
                    System.out.println("Error: item not found in items file.");
                    continue;
                }
            } catch (FileNotFoundException e) {
                // Display error message if the file was not found
                System.out.println("Error: items file not found.");
                return;
            } catch (NumberFormatException e) {
                // Display error message if the price in the file is not a valid number
                System.out.println("Error: invalid price format in items file.");
                return;
            }
            // Add the item to the order
            order.addItem(new Item(itemName, itemPrice));
        }

        // Calculate the total order amount and display it
        double total = order.calculateTotal();
        System.out.println("Total order amount: $" + total);

        // If payment method is cash, prompt user to enter amount paid and calculate change
        if (PaymentMethod.equalsIgnoreCase("cash")) {
            double amountPaid = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter amount paid: $");
                String input = scanner.nextLine();
                try {
                    amountPaid = Double.parseDouble(input);
                    if (amountPaid >= total) {
                        validInput = true;
                    } else {
                        // Display error message if the amount paid is less than the total order amount
                        System.out.println("Error: amount paid is less than total order amount.");
                    }
                } catch (NumberFormatException e) {
                    // Display error message if the input is not a valid number
                    System.out.println("Error: invalid input. Please enter a numeric value.");
                }
            }
            double change = amountPaid - total;
            System.out.println("Change: $" + change);
        }

        // Mark the order as paid and delivered
        order.markAsPaid();
        order.markAsDelivered();

        // Display whether the order is delivered
        System.out.println("Order is delivered: " + order.isDelivered());
    }
}
