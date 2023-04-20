package CampingStore242;

public class Tent extends Product {
    private int capacity;

    public Tent(String brand, String model, String description, double price, String condition, int capacity,int id) {
        super(brand, model, description, price, condition, id);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
