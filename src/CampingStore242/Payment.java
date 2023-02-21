package CampingStore242;

/**Payment class defines all the payment for the products
 * @Author Sanchit Patel
 */
public abstract class Payment {
    private double paymentCharge;

    public Payment(double payCharge)
    {
        this.paymentCharge = payCharge;
    }

    /** Getter Method
     *
     * @return
     */
    public double getPaymentCharge() {
        return paymentCharge;
    }

    /**Method Signature
     *
     * @param pay
     * @return
     */
    public abstract double handlePayment(double pay);
}