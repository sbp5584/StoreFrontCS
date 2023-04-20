package CampingStore242;

/**This defines a product class with various attributes
 * @author Sanchit Patel
 */
public class Product {
    public int id;
    String name;
    String brand;
    String desc;
    double price;
    String condition;
    String size;


    public Product(String name, String brand, String desc, double price, String condition, int id) {
        this.name = name;
        this.brand = brand;
        this.desc = desc;
        this.price = price;
        this.condition = condition;
        this.id = id;
    }

    /**Getter Methods for Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *Setter Methods for Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Getter Method for Brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /** Getter Method for Desc
     * @return Desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     *Setter Methods for Brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /** Getter Method for Price
     * @return Price
     */
    public double getPrice() {
        return price;
    }

    /**
     *Setter Methods for Price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /** Getter Method for Condition
     * @return Condition
     */
    public String getCondition() {
        return condition;
    }
    /**
     * Setter Method for Condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }


    /** Getter Method for Size
     * @return size
     */

    public String getSize() {

        return size;
    }

    /**
     * Setter Method for size
     */
    public void setSize(String size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void add(Product selectedProduct) {
    }

    /**The toString Method is returning the String representation of the Product
     *
     * @return
     */
    public String toString() {
        return "name = " + getName() + "\n" + "Brand = " + getBrand() + "\n" + "Desc = " + getDesc() + "\n" + "Price = " + getPrice() + "\n" +
                "Condition = " + getCondition() + "\n" + "Size = " + getSize();
    }


}
