package CampingStore242;

/**
 * This class represents a lantern product that extends the Product class
 * and includes additional attributes specific to a lantern product
 */
public class Lantern extends Product {
    private String type;

    public Lantern(int id, String brand, String name, String desc, double price, String condition, String type) {
        super(id, name, brand, "", desc, price, condition);
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
