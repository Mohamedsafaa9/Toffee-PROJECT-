import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private final List<Item> itemList; // list to store items in the catalog

    // constructor to initialize itemList
    public Catalog() {
        this.itemList = new ArrayList<>();
    }

    // method to load items from a file and add them to the itemList
    public void loadItemsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // read first line of file
            while (line != null) { // loop until end of file
                String[] parts = line.split(","); // split line into parts using comma as separator
                String name = parts[0].trim(); // extract item name from parts
                String category = parts[1].trim(); // extract item category from parts
                String description = parts[2].trim(); // extract item description from parts
                String brand = parts[3].trim(); // extract item brand from parts
                double price = Double.parseDouble(parts[4].trim()); // extract item price from parts
                double discount = Double.parseDouble(parts[5].trim()); // extract item discount from parts
                Item item = new Item(name, category, description, brand, price, discount); // create new Item object with extracted values
                this.itemList.add(item); // add Item object to itemList
                line = reader.readLine(); // read next line of file
            }
        } catch (IOException e) {
            System.out.println("Error loading items from file: " + e.getMessage()); // print error message if there is an issue with loading the file
        }
    }

    // method to display all items in the itemList
    public void displayAllItems() {
        for (Item item : this.itemList) { // loop through each item in itemList
            System.out.println(item.getName() + " | " + item.getCategory() + " | " + item.getDescription()
                    + " | " + item.getBrand() + " | " + item.getPrice()); // display item information
        }
    }

    // main method to test Catalog class
    public static void main(String[] args) {
        Catalog catalog = new Catalog(); // create new Catalog object
        catalog.loadItemsFromFile("items.txt"); // load items from file
        catalog.displayAllItems(); // display all items in catalog
    }
}
