package CampingStore242;

/**Main class contain code to call methods
 * @Author Sanchit Patel
 */

public class Main {
    static String store_name;  //Class level variable

    public static void main(String[] args) {
        Store store = new Store("Camping Store" +"\n======\n");
        System.out.println(store.Str());

        ProductsCart m = new ProductsCart();

        for (int i = 0; i < m.Tent.length; i++) {
            System.out.println("Name = " + m.Tent[i].name +"\n======\n" + "Brand = "+ m.Tent[i].brand+ ", " +  "Size = " +
                    m.Tent[i].size + ", " + "Desc = " + m.Tent[i].desc + ", " + "Price = " + m.Tent[i].price
                    + ", " + " Condition = " + m.Tent[i].condition + "\n");
        }

        for (int i = 0; i < m.Sleeping_bag.length; i++) {
            System.out.println("Name = " + m.Sleeping_bag[i].name +"\n======\n" + "Brand = "+ m.Sleeping_bag[i].brand+ ", " +  "Size = " +
                    m.Sleeping_bag[i].size + ", " + "Desc = " + m.Sleeping_bag[i].desc + ", " + "Price = " + m.Sleeping_bag[i].price
                    + ", " + " Condition = " + m.Sleeping_bag[i].condition + "\n");
        }




        //double saleItem = 8000.00;
        //double paTotal = Sale.getPATax(saleItem);

        //System.out.println(paTotal);
        //System.out.println(Sale.getPATax(saleItem));


        //System.out.println(Sale.getNJTax(8000.00));

        System.out.println(("DE Tax:- ") + Sale.getTax(8000.00, StateCode.DE));
        System.out.println(("PA Tax:- ") + Sale.getTax(8000.00, StateCode.PA));
        System.out.println(("CT Tax:- ") + Sale.getTax(8000.00, StateCode.CT));
        System.out.println(("NJ Tax:- ") + Sale.getTax(8000.00, StateCode.NJ));

        System.out.println(("Discount:- ") + ("$") + Sale.getDiscount(800));


        Cash cash = new Cash(.20);
        System.out.println(("Cash:- ") +("$") + cash.handlePayment(10000.00));





        CreditCard card = new CreditCard(.15);
        card.setCreditcardexpiryDate();



        System.out.println("Credit Card Exp Date: " + card.getSetCreditcardexpiryDate());
        System.out.println("Credit Card Check Master Card valid: "+ Luhn.Check("1234222233334444"));
        System.out.println("Credit Card Check Discover Card valid: "+ Luhn.Check("1234333322221111"));
        System.out.println("Credit Card Check Chime valid: "+ Luhn.Check("4444133322222111"));
        System.out.println("Credit Card Check: " + Luhn.Check("4444333322221111"));
    }
}