import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private final List<Item> itemList;

    public Catalog() {
        this.itemList = new ArrayList<>();
    }

    public void loadItemsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                String category = parts[1].trim();
                String description = parts[2].trim();
                String brand = parts[3].trim();
                double price = Double.parseDouble(parts[4].trim());
                double discount = Double.parseDouble(parts[5].trim());
                Item item = new Item(name, category, description, brand, price, discount);
                this.itemList.add(item);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error loading items from file: " + e.getMessage());
        }
    }

    public void displayAllItems() {
        for (Item item : this.itemList) {
            System.out.println(item.getName() + " | " + item.getCategory() + " | " + item.getDescription()
                    + " | " + item.getBrand() + " | " + item.getPrice());
        }
    }

    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.loadItemsFromFile("items.txt");
        catalog.displayAllItems();
    }
}
