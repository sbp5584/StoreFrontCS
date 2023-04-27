package CampingStore242;
/**
 * Represents a product in the camping store.
 */
public class Product {
    // Private fields for the product's properties
    private int id;
    private String name;
    private String brand;
    private String size;
    private String desc;
    private double price;
    private String condition;

    /**
     * Constructs a new product with the given parameters.
     * @param id the product's ID
     * @param name the product's name
     * @param brand the product's brand
     * @param size the product's size
     * @param desc the product's description
     * @param price the product's price
     * @param condition the product's condition
     */
    public Product(int id, String name, String brand, String size, String desc, double price, String condition) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.desc = desc;
        this.price = price;
        this.condition = condition;
    }

    /**
     * @return the product's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product's name.
     * @param name the new name for the product
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the product's brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return the product's description
     */
    public String getDesc() {
        return desc;
    }

    // Setter method for the product brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter method for the product price
    public double getPrice() {
        return price;
    }

    // Setter method for the product price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter method for the product condition
    public String getCondition() {
        return condition;
    }

    // Setter method for the product condition
    public void setCondition(String condition) {
        this.condition = condition;
    }

    // Getter method for the product size
    public String getSize() {
        return size;
    }

    // Setter method for the product size
    public void setSize(String size) {
        this.size = size;
    }

    // Getter method for the product id
    public int getId() {
        return id;
    }

    // Setter method for the product id
    public void setId(int id) {
        this.id = id;
    }

    // Method to add another product to this product
    public void add(Product selectedProduct) {
    }

    /**
     * Returns a string representation of the product's properties.
     * @return a string representation of the product
     */
    @Override
    public String toString() {
        return "name = " + getName() + "\n" + "Brand = " + getBrand() + "\n" + "Desc = " + getDesc() + "\n" + "Price = " + getPrice() + "\n" +
                "Condition = " + getCondition() + "\n" + "Size = " + getSize();
    }

    // Method to get the object's theme
    public Object getTheme() {
        return getTheme();
}
}