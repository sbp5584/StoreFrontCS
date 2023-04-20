package CampingStore242;

public class SleepingBag extends Product {
    private String size;
    private int temperatureRating;

    public SleepingBag(String brand, String model, String description, double price, String condition, String size, int id) {
        super(brand, model, description, price, condition,id);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getTemperatureRating() {
        return temperatureRating;
    }

    public void setTemperatureRating(int temperatureRating) {
        this.temperatureRating = temperatureRating;
    }
}
