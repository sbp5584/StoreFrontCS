package CampingStore242;
/**
 * Main class for the CampingStore242 application.
 * @author Sanchit Patel
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main {
    private JFrame frame;
    private ProductsCart cart;
    private ArrayList<Product> selectedProducts;
    private JTextArea cartSummary;
    private CustomerGUI customerGUI;
    /**
     * Main method to start the application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main mainApp = new Main();
                mainApp.createAndShowGUI();
                mainApp.createAndShowCustomerGUI();
            }

        });
    }
    /**
     * Creates and displays the CustomerGUI.
     */

    private void createAndShowCustomerGUI() {
        customerGUI = new CustomerGUI(this); // Pass the Main instance
        customerGUI.createAndShowGUI();
        customerGUI.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        customerGUI.frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                createAndShowGUI();
            }
        });
    }
    /**
     * Handles new customer creation by hiding CustomerGUI and showing the CampingStore GUI.
     */

    public void onNewCustomerCreated() {
        // Hide the CustomerGUI frame
        customerGUI.frame.setVisible(false);

        // Show the CampingStore GUI
        createAndShowGUI();
    }
    /**
     * Creates and displays the CampingStore GUI.
     */

    private void createAndShowGUI() {
        cart = new ProductsCart();
        selectedProducts = new ArrayList<>();

        frame = new JFrame("Camping Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Create a label for the welcome message
        JLabel welcomeLabel = new JLabel("Welcome to the Camping Store!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(50, 100, 200));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Create a panel to display the products
        JPanel productsPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(productsPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        for (Product product : cart.getAllProductsCart()) {
            JButton productButton = new JButton(product.getName() + " (" + product.getBrand() + ")");
            productButton.setFont(new Font("Arial", Font.PLAIN, 18));
            productButton.setForeground(new Color(100, 100, 100));
            productButton.setBackground(new Color(240, 240, 240));
            productButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(180, 180, 180)));
            productButton.addActionListener(new ProductButtonListener(product));
            productsPanel.add(productButton);
        }

        // Create a panel to display the cart summary
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(50, 100, 200)), "Cart Summary"));
        mainPanel.add(cartPanel, BorderLayout.EAST);

        cartSummary = new JTextArea();
        cartSummary.setEditable(false);
        cartSummary.setLineWrap(true);
        cartSummary.setWrapStyleWord(true);
        cartSummary.setFont(new Font("Arial", Font.PLAIN, 14));
        cartPanel.add(cartSummary, BorderLayout.CENTER);

        // Add a "Checkout" button to the cart panel
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBackground(new Color(50, 100, 200));
        checkoutButton.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });
        cartPanel.add(checkoutButton, BorderLayout.SOUTH);

        updateCartSummary();

        frame.setVisible(true);
    }

    /**
     * Inner class for handling product button actions.
     */
    private class ProductButtonListener implements ActionListener {
        private Product product;

        public ProductButtonListener(Product product) {
            this.product = product;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Add the selected product to the list
            selectedProducts.add(product);
            updateCartSummary();

            // Show a confirmation dialog
            int result = JOptionPane.showConfirmDialog(frame,
                    "You have selected the following product:\n" + productInfo(product) + "\nDo you want to continue shopping?",
                    "Product Selected", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.NO_OPTION) {
                // Prompt for payment
                promptForPayment();
            }
        }
    }
    /**
     * Updates the cart summary displayed in the JTextArea.
     */
    private void updateCartSummary() {
        StringBuilder summary = new StringBuilder("Cart Summary:\n\n");
        double totalPrice = 0;

        for (Product product : selectedProducts) {
            summary.append(product.getName()).append(" - $").append(product.getPrice()).append("\n");
            totalPrice += product.getPrice();
        }

        summary.append("\nTotal Price: $").append(totalPrice);
        cartSummary.setText(summary.toString());
    }
    /**
     * Processes the checkout action.
     */
    private void checkout() {
        if (selectedProducts.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Your cart is empty. Please add products to the cart.", "Empty Cart", JOptionPane.WARNING_MESSAGE);
            return;
        }

        promptForPayment();
    }
    /**
     * Prompts the user for payment and processes it.
     */
    private void promptForPayment() {
        // Calculate the total price of the selected products
        double totalPrice = 0;
        for (Product product : selectedProducts) {
            totalPrice += product.getPrice();
        }

        // Show a payment dialog
        String[] paymentMethods = {"Credit Card", "Cash"};
        int paymentMethod = JOptionPane.showOptionDialog(frame,
                "Your total is $" + totalPrice + "\nPlease select a payment method:",
                "Payment", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, paymentMethods, paymentMethods[0]);

        // Process the payment based on the selected payment method
        if (paymentMethod == 0) {
            String cardNumber = JOptionPane.showInputDialog(frame, "Enter your credit card number:");

            // Validate the card number using the Luhn algorithm
            if (!Luhn.Check(cardNumber)) {
                JOptionPane.showMessageDialog(frame, "Invalid credit card number. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String expiryDate = JOptionPane.showInputDialog(frame, "Enter your expiration date (MM/YY):");
            String cvv = JOptionPane.showInputDialog(frame, "Enter your security code (CVV):");


            JOptionPane.showMessageDialog(frame, "Credit card payment successful. Thank you for your purchase!", "Payment", JOptionPane.INFORMATION_MESSAGE);
        } else if (paymentMethod == 1) {
            String cashAmountStr = JOptionPane.showInputDialog(frame, "Enter the amount of cash you would like to pay:");
            double cashAmount = Double.parseDouble(cashAmountStr);

            if (cashAmount >= totalPrice) {
                JOptionPane.showMessageDialog(frame, "Payment successful. Thank you for your purchase!", "Payment", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Insufficient cash. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Clear the selected products
        selectedProducts.clear();
        updateCartSummary();
    }
    /**
     * Generates a string with product information.
     *
     * @param product The product object
     * @return A formatted string with product information
     */

    private String productInfo(Product product) {
        return "ID: " + product.getId() + ", Name: " + product.getName() + ", Brand: " + product.getBrand() + ", Description: " + product.getDesc()
                + ", Size: " + product.getSize() + ", Price: $" + product.getPrice() + ", Condition: " + product.getCondition();
    }
}


