/**
 * The Item class represents a product in the catalog.
 * It contains information about the product, such as its name, category, description, brand, price, and discount.
 */
public class Item {
    private String name; // The name of the item.
    private String category; // The category of the item.
    private String description; // The description of the item.
    private String brand; // The brand of the item.
    private double price; // The price of the item.
    private double discount; // The discount percentage of the item.

    /**
     * Constructor for creating a new Item object.
     *
     * @param name        The name of the item.
     * @param category    The category of the item.
     * @param description The description of the item.
     * @param brand       The brand of the item.
     * @param price       The price of the item.
     * @param discount    The discount percentage of the item.
     */
    public Item(String name, String category, String description, String brand, double price, double discount) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
    }

    /**
     * Getter method for the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the category of the item.
     *
     * @return The category of the item.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Getter method for the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter method for the brand of the item.
     *
     * @return The brand of the item.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Getter method for the price of the item.
     *
     * @return The price of the item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter method for the discount percentage of the item.
     *
     * @return The discount percentage of the item.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Calculates the discounted price of the item based on the discount percentage.
     *
     * @return The discounted price of the item.
     */
    public double getDiscountedPrice() {
        return price * (1 - discount/100);
    }
}
