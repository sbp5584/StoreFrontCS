package CampingStore242;
/**
 * DatabaseConnection class for managing database operations related to the Customer class.
 *
 * @author Sanchit Patel
 */
import java.sql.*;
import java.util.*;

public class DatabaseConnection {
    /**
     * Reads all customer records from the database and returns them as an ArrayList.
     *
     * @return An ArrayList of Customer objects
     */

    public static void main(String[] args) {


        readAllSQL();
        readByIdSQL(1);
        Customer Tpcs = new Customer(1,"Sanchit", "Patel", "SSP.PP@example.com", "555-1234");
        createSQL(5, Tpcs);
        updateSQL(4, Tpcs);
        deleteSQL(1);
        readAllSQL();
    }

    static ArrayList<Customer> readAllSQL() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            // Here, "BikeStore" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer3", "root", "Dancer009008@");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Tpcs");
            while (rs.next()) {
                Customer Tpcs = new Customer( rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone"));
                customers.add(Tpcs);
            }
            for (Customer Tpcs : customers) {
                System.out.println(Tpcs.getId() + ", " + Tpcs.getFirstName() + ", " + Tpcs.getLastName() + ", " +
                        Tpcs.getEmail() + ", " + Tpcs.getPhoneNumber());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customers;
    }
    /**
     * Reads a specific customer record by ID from the database and prints it.
     *
     * @param id The ID of the customer to read
     */

    private static void readByIdSQL(int id) {
        try {
            // Here, "Bike Store" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer3", "root", "Dancer009008@");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Tpcs WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer Tpcs = new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone"));
                System.out.println(Tpcs.getId() + ", " + Tpcs.getFirstName() + ", " + Tpcs.getLastName() + ", " +
                        Tpcs.getEmail() + ", " + Tpcs.getPhoneNumber());
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * Inserts a new customer record into the database.
     *
     * @param id The ID of the customer
     * @param Tpcs The Customer object containing the data to insert
     */
    static void createSQL(int id, Customer Tpcs) {
        try {
            // Here, "Bike Store" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer3", "root", "Dancer009008@");
            PreparedStatement ps = con.prepareStatement("INSERT INTO Tpcs (id, first_name, last_name, email, phone) " +
                    "VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, Tpcs.getFirstName());
            ps.setString(3, Tpcs.getLastName());
            ps.setString(4, Tpcs.getEmail());
            ps.setString(5, Tpcs.getPhoneNumber());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * Updates an existing customer record in the database.
     *
     * @param id The ID of the customer to update
     * @param Tpcs The Customer object containing the updated data
     */
    static void updateSQL(int id, Customer Tpcs) {
        try {
            // Here, "Bike Store" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer3", "root", "Dancer009008@");
            PreparedStatement ps = con.prepareStatement("UPDATE Tpcs SET first_name = ?, last_name = ?, email = ?, " +
                    "phone = ? WHERE id = ?");
            ps.setString(1, Tpcs.getFirstName());
            ps.setString(2, Tpcs.getLastName());
            ps.setString(3, Tpcs.getEmail());
            ps.setString(4, Tpcs.getPhoneNumber());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * Deletes a customer record from the database by ID.
     *
     * @param id The ID of the customer to delete
     */

    static void deleteSQL(int id) {
        try {
            // Here, "Tpcs" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer3", "root", "Dancer009008@");
            PreparedStatement ps = con.prepareStatement("DELETE FROM Tpcs WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
  }
}

}