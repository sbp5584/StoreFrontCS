package CampingStore242;
/**
 * Luhn class for validating credit card numbers using the Luhn algorithm.
 * @author Sanchit Patel
 */
public class Luhn {
    /**
     * Checks if the given credit card number is valid using the Luhn algorithm.
     *
     * @param ccNumber The credit card number as a string
     * @return true if the credit card number is valid, false otherwise
     */
    public static boolean Check(String ccNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        System.out.println("Sum: " + sum);
        return (sum % 10 == 0);
    }
}
