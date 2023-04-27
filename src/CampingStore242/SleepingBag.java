package CampingStore242;
/**
 * Represents a sleeping bag in the camping store.
 * SleepingBag extends the Product class to include a temperature rating.
 */

// Define the SleepingBag class, which extends the Product class
public class SleepingBag extends Product {
    /**
     * Constructs a new sleeping bag with the given parameters.
     * @param id the sleeping bag's ID
     * @param brand the sleeping bag's brand
     * @param name the sleeping bag's name
     * @param desc the sleeping bag's description
     * @param price the sleeping bag's price
     * @param condition the sleeping bag's condition
     * @param size the sleeping bag's size
     * @param temperatureRating the sleeping bag's temperature rating
     */

    // Add a private field to store the temperature rating of the sleeping bag
    private int temperatureRating;

    // Define the constructor for the SleepingBag class
    public SleepingBag(int id, String brand, String name, String desc, double price, String condition, String size, int temperatureRating) {
        // Call the constructor of the parent Product class to initialize the common fields
        super(id, name, brand, size, desc, price, condition);
        // Initialize the temperatureRating field using the parameter passed to the constructor
        this.temperatureRating = temperatureRating;
    }

    /**
     * @return the sleeping bag's temperature rating
     */
    public int getTemperatureRating() {
        return temperatureRating;
    }

    /**
     * Sets the sleeping bag's temperature rating.
     * @param temperatureRating the new temperature rating for the sleeping bag
     */
    public void setTemperatureRating(int temperatureRating) {
        this.temperatureRating = temperatureRating;
    }

    /**
     * Returns a string representation of the sleeping bag's properties.
     * @return a string representation of the sleeping bag, including the temperature rating
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Temperature Rating = " + getTemperatureRating();
}
}