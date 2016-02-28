import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mihai on 26.02.2016.
 */
public class Customer {
    String firstName;
    String lastName;
    ArrayList<Account> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new ArrayList<Account>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount() {
        System.out.println("What kind of account do you want?\n1.Term Account\n2.Current Account");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                System.out.println("What amount of money do you want to deposit?");
                Account ac = new TermAccount(sc.nextDouble());
                accounts.add(ac);
                break;
            case 2:
                System.out.println("What amount of money do you want to deposit?");
                Account currentAccount = new CurrentAccount(sc.nextDouble());
                accounts.add(currentAccount);
                break;
            default:
                break;
        }
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public Account getAccount(int index) {
        return accounts.get(index);
    }
}
