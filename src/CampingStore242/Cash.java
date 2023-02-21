package CampingStore242;

/**Cash extends to Payment
 * author Sanchit Patel
 */

 public class Cash extends Payment{
    //Cash takes payCharge and passes it to Payment using parent
    public Cash(double payCharge){
        super(payCharge);
    }
    /**Method signature was defined in the payment class
     */
     public double handlePayment(double pay){
        return pay * super.getPaymentCharge();
    }
}

