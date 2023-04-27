
package CampingStore242;
/**

 CustomerGUI class representing a graphical user interface for managing customers in the Camping Store system.
 @author Sanchit Patel
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class CustomerGUI {

    JFrame frame;
    private JTextField idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextArea resultTextArea;
    private JButton createButton;
    private Main mainApp;

    public CustomerGUI(Main mainApp) {
        this.mainApp = mainApp;
        initialize();
    }

    /**
     * Initializes the CustomerGUI and sets up components.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(idLabel);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 36, 89, 14);
        frame.getContentPane().add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 61, 89, 14);
        frame.getContentPane().add(lastNameLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 86, 46, 14);
        frame.getContentPane().add(emailLabel);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 111, 46, 14);
        frame.getContentPane().add(phoneLabel);

        idTextField = new JTextField();
        idTextField.setBounds(109, 8, 186, 20);
        frame.getContentPane().add(idTextField);
        idTextField.setColumns(10);
        idTextField.getDocument().addDocumentListener(new DocumentListener() {
            private void checkIdField() {
                createButton.setEnabled(!idTextField.getText().isEmpty());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkIdField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkIdField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkIdField();
            }
        });

        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(109, 33, 186, 20);
        frame.getContentPane().add(firstNameTextField);
        firstNameTextField.setColumns(10);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(109, 58, 186, 20);
        frame.getContentPane().add(lastNameTextField);
        lastNameTextField.setColumns(10);

        emailTextField = new JTextField();
        emailTextField.setBounds(109, 83, 186, 20);
        frame.getContentPane().add(emailTextField);
        emailTextField.setColumns(10);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(109, 108, 186, 20);
        frame.getContentPane().add(phoneTextField);
        phoneTextField.setColumns(10);

        createButton = new JButton("Create");
        createButton.setEnabled(false);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText());
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String email = emailTextField.getText();
                String phone = phoneTextField.getText();
                Customer customer = new Customer(id, firstName, lastName, email, phone);
                DatabaseConnection.createSQL(id, customer);
                resultTextArea.append("Created customer: " + customer + "\n");

                mainApp.onNewCustomerCreated();
            }
        });
        createButton.setBounds(10, 136, 89, 23);
        frame.getContentPane().add(createButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            int id = Integer.parseInt(idTextField.getText());
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            Customer customer = new Customer(id, firstName, lastName, email, phone);
            DatabaseConnection.updateSQL(id, customer);
            resultTextArea.append("Updated customer: " + customer + "\n");
        });
        updateButton.setBounds(109, 136, 89, 23);
        frame.getContentPane().add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            int id = Integer.parseInt(idTextField.getText());
            DatabaseConnection.deleteSQL(id);
            resultTextArea.append("Deleted customer with ID: " + id + "\n");
        });
        deleteButton.setBounds(208, 136, 89, 23);
        frame.getContentPane().add(deleteButton);

        JButton readAllButton = new JButton("Read All");
        readAllButton.addActionListener(e -> {
            resultTextArea.setText("");
            ArrayList<Customer> customers = DatabaseConnection.readAllSQL();
            for (Customer customer : customers) {
                resultTextArea.append(customer.toString() + "\n");
            }
        });
        readAllButton.setBounds(307, 136, 89, 23);
        frame.getContentPane().add(readAllButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setBounds(10, 170, 464, 280);
        frame.getContentPane().add(scrollPane);
    }
    /**
     * Creates and shows the GUI.
     */
    public void createAndShowGUI() {
        frame.setVisible(true);
    }
    /**
     * The main method of the CustomerGUI.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main main = new Main();
                CustomerGUI window = new CustomerGUI(main);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

