import com.google.gson.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try
        {
            Customer custs[] = {new Customer("Sanchit", "Patel", "ssp112@example.com", "222-111-3333", "1 West ST RD"),
                    new Customer("Been", "Patel", "bbp111@example.com", "222-222-3333", "2 North ST RD"),
                    new Customer("Rob", "Smith", "RS11@example.com", "222-333-3333", "3 East ST RD")};

            try (FileWriter writer = new FileWriter("Customer.json")){
                writer.write(new Gson().toJson(custs));
            }

            Customer[] custs2 = new Gson().fromJson(new FileReader("Customer.json"), Customer[].class);
            for (Customer cust : custs2){
                System.out.println("\nName: " + cust.getFirstName() + " " + cust.getLastName());
                System.out.println("Email : " + cust.getEmail());
                System.out.println("Phone Number : " + cust.getPhone());

            }
        }catch(Exception e){}
}
}
