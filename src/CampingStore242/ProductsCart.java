package CampingStore242;

/**Creates a cart for all the products
 * @Author Sanchit Patel
 */
public class ProductsCart {
    static protected Product[] Tent;
    public ProductsCart(){
        Tent = new Product[]{
                new Product("Ozark trail", "Wenzel", "10-person tent", "10 person", 3000, "New"),
                new Product("Dome Tent","North_Face","Sumit_gold tent","6 person",2500,"New"),
        };



    }
    static protected Product[] Sleeping_bag;
    {
        Sleeping_bag = new Product[]{
                new Product("Coleman","The North Face","Rectangular Size","Long",40,"New"),
                new Product("Katahdin","North Face","Below freezing temp","Long",100,"New")
        };
    }
}


