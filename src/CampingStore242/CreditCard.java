package CampingStore242;
import java.util.Date;


/**Class CreditCard extends from Payment
 * @Author Sanchit Patel
 */

public class CreditCard extends Payment{
    /**Class Properties
     *
     */
    private String cardName;
    private String cardNumber;
    private String cvv;
    private Date setCreditcardexpiryDate;


    /**Constructor Method
     *
     * @param payCharge
     */
    public CreditCard(double payCharge) {
        super(payCharge);
    }
    //Method signature was defined in the Payment class
    public double handlePayment(double pay){
        return pay * super.getPaymentCharge();
    }
    // Set Credit Card ExpiryDate
    public void setCreditcardexpiryDate() {
        setCreditcardexpiryDate = new Date();
    }
    //Get Credit Card ExpiryDate
    public Date getSetCreditcardexpiryDate(){
        return setCreditcardexpiryDate;
    }
}