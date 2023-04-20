package CampingStore242;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a cart for all the products
 *
 * @Author Sanchit Patel
 */
public class ProductsCart {
    private List<Product> products;

    public ProductsCart() {
        products = new ArrayList<>();
        addTents();
        addSleepingBags();
        addStoves();
        addLanterns();
    }

    private void addTents() {
        products.add(new Tent("Ozark trail", "Wenzel", "10-person tent", 3000, "New", 10,1));
        products.add(new Tent("Dome Tent", "North_Face", "Sumit_gold tent", 2500, "New", 6,2));
        products.add(new Tent("Instant Cabin Tent", "Coleman", "Dark Room", 5000, "New",10,3));
    }

    private void addSleepingBags() {
        products.add(new SleepingBag("Coleman", "The North Face", "Rectangular Size", 40, "New", "Long",4));
        products.add(new SleepingBag("Katahdin", "North Face", "Below freezing temp", 100, "New", "Long",5));
        products.add(new SleepingBag("Marmot", "Never Summer", "Below freezing temp", 200, "New", "Long",6));
    }

    private void addStoves() {
        products.add(new Stove("2-Burner Gas Stove", "Coleman", "2-Burner Gas Stove", 100,"New","Wood Fire",7));
        products.add(new Stove("Onyx", "Samsung", "Electric", 200,"New","Electric",8));
        products.add(new Stove("Jet boil","LG" , "Flash Stove",150 ,"New","Propane tank",9));
    }

    private void addLanterns() {
        products.add(new Lantern("Black Diamond", "Apollo Lantern", "Rechargeable Lantern",80,"New","Outdoor",10));
        products.add(new Lantern("Coleman", "Quad LED Lantern", "Battery Powered Lantern", 50,"New","Indoor",11 ));
        products.add(new Lantern("Stream light", "Super Siege Lantern", "Rechargeable Lantern", 150,"New","Indoor and Outdoor",12 ));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int index) {
        products.remove(index);
    }

    public void replaceProduct(int index, Product product) {
        products.set(index, product);
    }

    public List<Product> getAllProductsCart() {
        return new ArrayList<>(products);
    }
}
