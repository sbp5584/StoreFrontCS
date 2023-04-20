package CampingStore242;

/**Payment class defines all the payment for the products
 * @Author Sanchit Patel
 */
public abstract class Payment {
    private double paymentCharge;

    public Payment(double payCharge) {
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
    
    public double handlePayment(double pay) {
        System.out.println("Processing credit card payment...");
        // logic to process credit card payment
        double totalPayment = pay + getPaymentCharge();
        System.out.println("Credit card payment of " + totalPayment + " processed successfully.");
        return totalPayment;
    }

    public abstract boolean process();
}


