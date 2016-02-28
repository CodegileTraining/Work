/**
 * Created by Mihai on 26.02.2016.
 */
public abstract class Account{
    Double balance;

    public Account(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }


    public void deposit(Double amount) {
        this.balance = this.balance + amount;
    }

    public String toString() {
        return balance.toString();
    }

    public abstract void withDraw(Double amount) throws MyExceptions;

    public abstract String getDescription();
}
