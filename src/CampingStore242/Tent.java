package CampingStore242;
/**
 * Represents a tent in the camping store.
 * Tent extends the Product class to include a capacity.
 */

public class Tent extends Product {
    private int capacity;
    /**
     * Constructs a new tent with the given parameters.
     * @param id the tent's ID
     * @param brand the tent's brand
     * @param name the tent's name
     * @param desc the tent's description
     * @param price the tent's price
     * @param condition the tent's condition
     * @param capacity the tent's capacity (number of persons it can accommodate)
     */

    public Tent(int id, String brand, String name, String desc, double price, String condition, int capacity) {
        super(id, name, brand, "", desc, price, condition);
        this.capacity = capacity;
    }

    /**
     * @return the tent's capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the tent's capacity.
     * @param capacity the new capacity for the tent
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
