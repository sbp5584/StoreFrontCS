package CampingStore242;
/**
 * Represents a stove in the camping store.
 * Stove extends the Product class to include a type.
 */
public class Stove extends Product {
    private String type;
    /**
     * Constructs a new stove with the given parameters.
     * @param id the stove's ID
     * @param name the stove's name
     * @param brand the stove's brand
     * @param desc the stove's description
     * @param size the stove's size
     * @param price the stove's price
     * @param condition the stove's condition
     * @param type the stove's type
     */

    public Stove(int id, String name, String brand, String desc, String size, double price, String condition, String type) {
        super(id, name, brand, desc, size, price, condition);
        this.type = type;
    }
    /**
     * @return the stove's type
     */

    public String getType() {
        return type;
    }
    /**
     * Sets the stove's type.
     * @param type the new type for the stove
     */

    public void setType(String type) {
        this.type = type;
    }
    /**
     * Returns a string representation of the stove's properties.
     * @return a string representation of the stove, including the type
     */
    public String toString() {
        return super.toString() + "\n" + "Type = " + getType();
    }
}
