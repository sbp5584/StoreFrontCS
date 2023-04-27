package CampingStore242;
import java.util.Date;

/** Class CreditCard extends from Payment
 * @Author Sanchit Patel
 */
public abstract class CreditCard extends Payment {
    /** Class Properties
     */
    private String cardName;
    private String cardNumber;
    private int cvv;
    private Date setCreditcardexpiryDate;
    private String expirationDate;

    public CreditCard(double payCharge, String cardNumber, String cardHolderName, String expirationDate) {
        super(payCharge);
        if (!Luhn.Check(cardNumber)) {
            throw new IllegalArgumentException("Invalid credit card number.");
        }
        this.cardNumber = cardNumber;
        this.cardName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    /** Constructor Method
     * @param payCharge
     */
    public CreditCard(double payCharge) {
        super(payCharge);
    }

    // Method signature was defined in the Payment class
    public double handlePayment(double pay) {
        return pay * super.getPaymentCharge();
    }

    // Set Credit Card ExpiryDate
    public void setCreditcardexpiryDate() {
        setCreditcardexpiryDate = new Date();
    }

    // Get Credit Card ExpiryDate
    public Date getSetCreditcardexpiryDate() {
        return setCreditcardexpiryDate;
    }

    // Add Luhn validation method
    public boolean validateCardNumber() {
        return Luhn.Check(this.cardNumber);
    }
}
