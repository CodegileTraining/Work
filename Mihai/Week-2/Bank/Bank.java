import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Mihai on 26.02.2016.
 */
public class Bank {
    private Bank() {
        customers = new ArrayList<Customer>();
    }

    ArrayList<Customer> customers;

    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customers.add(customer);
    }
    public void addCustomer(Customer customer,int index){
        customers.add(index,customer);
    }

    private static Bank instantce = new Bank();

    public static Bank getInstance() {
        return instantce;
    }

    public int getNumberofCustomers() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public void getReport(String fileName) {

        Customer customer;
        try {
            PrintWriter printWriter = new PrintWriter(fileName + ".txt", "UTF-8");
            for (int i = 0; i < customers.size(); i++) {
                customer = customers.get(i);
                printWriter.println(customer.firstName + " " + customer.getLastName());
                for (int j = 0; j < customer.getNumberOfAccounts(); j++) {
                    printWriter.println(customer.getAccount(j).getDescription() + " " + customer.getAccount(i).toString());
                }
                printWriter.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
