package CampingStore242;

/**
 * This class represents a lantern product that extends the Product class
 * and includes additional attributes specific to a lantern product
 */
public class Lantern extends Product {
    private String type;

    /**
     * Constructor for the Lantern class
     * @param name - the name of the lantern
     * @param brand - the brand of the lantern
     * @param desc - a description of the lantern
     * @param price - the price of the lantern
     * @param condition - the condition of the lantern (e.g. new, used, refurbished)
     * @param type - the type of the lantern (e.g. LED, gas, electric)
     */
    public Lantern(String name, String brand, String desc, double price, String condition, String type, int id) {
        super(name, brand, desc, price, condition, id);
        this.type = type;
    }

    /**
     * Getter method for the type attribute
     * @return the type of the lantern
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for the type attribute
     * @param type - the type of the lantern (e.g. LED, gas, electric)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The toString method returns a string representation of the Lantern object
     * @return a string representation of the Lantern object
     */
    public String toString() {
        return super.toString() + "\n" + "Type = " + getType();
    }
}
