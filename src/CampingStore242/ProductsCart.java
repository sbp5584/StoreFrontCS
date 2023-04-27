package CampingStore242;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates a cart for all the products
 *
 * @Author Dylan Sowden
 */
public class ProductsCart {
    private List<Product> products;

    // Constructor that initializes the cart with products
    public ProductsCart() {
        products = new ArrayList<>();
        addProduct(new Tent(1, "Wenzel", "Ozark trail", "10-person tent", 3000, "New", 10));
        addProduct(new Tent(2, "NorthFace", "Sumitgold tent", "Dome Tent", 2500, "Used", 8));
        addProduct(new Tent(3, "Coleman", "Dark Room", "Instant Cabin Tent", 5000,"New",10));
        addProduct(new SleepingBag(4,"NorthFace","Coleman", "The North Face", 50, "New", "Long", -10));
        addProduct(new SleepingBag(5,"Katahdin", "North Face", "Below freezing temp", 100, "Used", "Long",1));
        addProduct(new SleepingBag(6,"Marmot", "Never Summer", "Below freezing temp", 200, "New", "Long",10));
        addProduct(new Stove(7,"CampFire" , "Coleman", "2-Burner Gas Stove","New",100,"Used","Outdoor"));
        addProduct(new Stove(8, "Onyx", "Samsung", "Electric","Large",200,"New","Outdoor"));
        addProduct(new Stove(9,"Jet Boil" , "LG","Flash Stove","Compact",150,"New","Outdoor"));
        addProduct(new Lantern(10, "Black Diamond", "Apollo Lantern", "Rechargeable Lantern", 80, "New", "Outdoor"));
        addProduct(new Lantern(11, "Coleman", "Quad LED Lantern", "Battery Powered Lantern", 50, "New", "Indoor"));
        addProduct(new Lantern(12, "Stream light", "Super Siege Lantern", "Rechargeable Lantern", 150, "New", "Indoor and Outdoor"));
    }

    // Method to add a product to the cart
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to remove a product from the cart
    public void removeProduct(int index) {
        products.remove(index);
    }

    // Method to replace a product in the cart with a new product
    public void replaceProduct(int index, Product product) {
        products.set(index, product);
    }

    // Method to get a copy of all the products currently in the cart
    public List<Product> getAllProductsCart() {
        return new ArrayList<>(products);
}
}