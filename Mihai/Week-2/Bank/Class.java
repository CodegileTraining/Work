import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by Mihai on 26.02.2016.
 */
public class Class {

    static Bank bank = Bank.getInstance();

    public static void modifyCustomer(Customer customer) throws MyExceptions {
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + "\n" +
                "What do you want to do with him?\n" +
                "1.Add Account\n" +
                "2.Number of accounts" +
                "3.See Accounts\n" +
                "4.Withdraw");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                customer.addAccount();
                break;
            case 2:
                System.out.println(customer.getNumberOfAccounts());
                break;
            case 3:
                for (int i = 0; i < customer.getNumberOfAccounts(); i++) {
                    System.out.println(i + 1 + " " + customer.getAccount(i).getDescription() + " " + customer.getAccount(i).getBalance());
                }
                break;
            case 4:
                System.out.println("Enter the number of account and the amount you want to withdraw\n");
                customer.getAccount(sc.nextInt()).withDraw(sc.nextDouble());
                break;
            default:
                break;
        }

    }

    public static Account createAccount(int type, Double amount) {
        Account account;
        if (type == 1) {
            account = new CurrentAccount(amount);
            return account;
        }
        account = new TermAccount(amount);
        return account;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, MyExceptions {
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?\n" +
                "1.Add Customer\n" +
                "2.See the status of a customer\n" +
                "3.Get a report\n" +
                "4.See the numbers of customers");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("What is his name?\n(FirstName LastName)\n");
                bank.addCustomer(sc.next(), sc.next());
                System.out.println("What do you want to do with him?\n" +
                        "1.Add Accoutn\n" +
                        "2.Nothing");
                i = sc.nextInt();
                if (i == 1) {
                    Customer customer = bank.getCustomer(bank.getNumberofCustomers() - 1);
                    customer.addAccount();
                    bank.addCustomer(customer, bank.getNumberofCustomers() - 1);
                }
                break;
            case 2:
                System.out.println("Enter the number of customer\n");
                i = sc.nextInt();
                modifyCustomer(bank.getCustomer(i));
                break;
            case 3:
                bank.getReport("Raport");
                break;
            case 4:
                System.out.println(bank.getNumberofCustomers());
                break;
        }


    }

}
