public class Item {
    private String name;
    private String category;
    private String description;
    private String brand;
    private double price;
    private double discount;

    public Item(String name, String category, String description, String brand, double price, double discount) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDiscountedPrice() {
        return price * (1 - discount/100);
    }
}
