package CampingStore242;

public class Stove extends Product {
    private String type;

    public Stove (String name, String brand, String desc, double price, String condition, String type, int id) {
        super(name, brand, desc, price, condition,id);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return super.toString() + "\n" + "Type = " + getType();
    }
}
