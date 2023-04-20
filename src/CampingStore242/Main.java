package CampingStore242;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String store_name; // Class level variable

    private static DatabaseConnection dbConnection;

    public static void main(String[] args) {
        System.out.println("\nWelcome To the Used Camping Store\n");

        // create an instance of the ProductsCart class
        ProductsCart cart = new ProductsCart();

        // print the details of all products in the cart
        for (Product product : cart.getAllProductsCart()) {
            System.out.println("Id = " + product.getId() + ", " + "Name = " + product.getName() + "\n======\n" + "Brand = "
                    + product.getBrand() + ", " + "Size = " + product.getSize() + ", " + "Desc = " + product.getDesc()
                    + ", " + "Price = " + product.getPrice() + ", " + " Condition = " + product.getCondition() + "\n");
        }

        Scanner scanner = new Scanner(System.in);
        boolean shopping = true;
        ArrayList<Product> selectedProducts = new ArrayList<>();

        while (shopping) {
            // prompt the user to select a product
            boolean isValidId = false;
            Product selectedProduct = null;
            while (!isValidId) {
                System.out.print("Enter the ID of the product you want to purchase: ");
                int productId = scanner.nextInt();

                // look up the product in the cart
                for (Product product : cart.getAllProductsCart()) {
                    if (product.getId() == productId) {
                        selectedProduct = product;
                        isValidId = true;
                        break;
                    }
                }

                if (!isValidId) {
                    System.out.println("No product found with ID " + productId + ". Please try again.");
                }
            }

            // add the selected product to the list
            selectedProducts.add(selectedProduct);

            // display the details of the selected product
            System.out.println("You have selected the following product:");
            System.out.println("ID = " + selectedProduct.getId() + ", " + "Name = " + selectedProduct.getName() + ", "
                    + "Brand = " + selectedProduct.getBrand() + "\n======\n" + "Description = " + selectedProduct.getDesc()
                    + ", " + "Size = " + selectedProduct.getSize() + ", " + " Price = " + selectedProduct.getPrice()
                    + ", " + " Condition = " + selectedProduct.getCondition() + "\n");

            // ask if the user wants to continue shopping
            System.out.print("Do you want to continue shopping? (Y/N) ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("n")) {
                shopping = false;
            }
        }

        // calculate the total price of the selected products
        double totalPrice = 0;
        for (Product product : selectedProducts) {
            totalPrice += product.getPrice();
        }

        // prompt the user to select a payment method
        System.out.println("Your total is $" + totalPrice);
        System.out.print("Please select a payment method (1: Credit Card, 2: Cash): ");
        int paymentMethod = scanner.nextInt();

        // process the payment based on the selected payment method
        if (paymentMethod == 1) {
            System.out.print("Please enter your credit card number: ");
            String creditCardNumber = scanner.next();
            System.out.print("Please enter your expiration date (MM/YY): ");
            String expirationDate = scanner.next();
            System.out.print("Please enter your security code: ");
            String securityCode = scanner.next();

            // create a CreditCardPayment object
            CreditCard payment = new CreditCard(totalPrice, creditCardNumber, expirationDate, securityCode) {
                @Override
                public boolean process() {
                    return false;
                }
            };

            // process the payment
            if (payment.process()) {
                System.out.println("Payment successful. Thank you for your purchase!");
            } else {
                System.out.println("Payment failed. Please try again.");
            }
        } else if (paymentMethod == 2) {
            System.out.println("Please enter the amount of cash you would like to pay: ");
            double cashAmount = scanner.nextDouble();

            // check if the cash amount is sufficient
            if (cashAmount >= totalPrice) {
                System.out.println("Payment successful. Thank you for your purchase!");
            } else {
                System.out.println("Insufficient cash. Please try again.");
            }
        } else {
            System.out.println("Invalid payment method. Please try again.");
        }

        // thank the user for shopping
        System.out.println("Thank you for shopping at the Used Camping Store!");
    }
}
