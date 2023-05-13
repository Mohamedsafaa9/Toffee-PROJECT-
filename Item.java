public class Item<price> {
    // Class variables
    private String name;
    private String category;
    private String description;
    private String brand;
    private double price;
    private double discountPercentage;

    // Constructor for the Item class
    public Item(String name, double price) {
        // Set class variables
        this.name = name;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    // Getter method for the 'name' variable
    public String getName() {
        return name;
    }

    // Setter method for the 'name' variable
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the 'category' variable
    public String getCategory() {
        return category;
    }

    // Setter method for the 'category' variable
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter method for the 'description' variable
    public String getDescription() {
        return description;
    }

    // Setter method for the 'description' variable
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter method for the 'brand' variable
    public String getBrand() {
        return brand;
    }

    // Setter method for the 'brand' variable
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter method for the 'price' variable
    public double getPrice() {
        return price;
    }

    // Setter method for the 'price' variable
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter method for the 'discountPercentage' variable
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    // Setter method for the 'discountPercentage' variable
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    // Method to calculate the discounted price of the item
    public double getDiscountedPrice() {
        double discountedPrice = price - (price * (discountPercentage / 100.0));
        return discountedPrice;
    }
}
