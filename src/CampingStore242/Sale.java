package CampingStore242;

/**Returns sales, tax, and discounts
 * @Author Sanchit Patel
 */
public class Sale {
    public static double getPATax(double saleTotal){
        return .06 * saleTotal;
    }
    public static double getNJTax(double saleTotal){
        return .06625 * saleTotal;
    }

    public static double getDiscount(double saleTotal){
        return saleTotal *= .01;

    }
    public static double getTax(double saleTotal, StateCode state){
        double total = 0.0;
        if (state == StateCode.PA)
            total = .06 * saleTotal;
        else if (state == StateCode.NJ)
            total = saleTotal * .06625;
        else if (state == StateCode.CT)
            total = saleTotal * .0635;
        return total;
    }
}
