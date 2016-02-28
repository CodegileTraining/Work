package Week2.Bank;

import Day4.MyException;

import java.time.LocalDate;

public class NormalAccount extends BankAccount {

	private LocalDate expirationDate;
	private final long limit = 1000;

	public NormalAccount(Customer customer, double money, LocalDate date, LocalDate date2) {
		super(customer, money, date);
		expirationDate = date2;
	}

	public LocalDate getDate() {
		return expirationDate;
	}

	public void setDate(LocalDate date) {
		this.expirationDate = date;
	}

	public void deposit(double amount) {
		LocalDate currentDate = LocalDate.now();
		try {
			if (amount < 0)
				throw new MyException("Invalid amount!");
			if (expirationDate.compareTo(currentDate) < 0)
				throw new MyException("Your account has expired in" + expirationDate + " !");
			this.setMoney(amount + this.getMoney());
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

	public void withdraw(double amount) {
		LocalDate currentDate = LocalDate.now();
		try {
			if (amount < 0)
				throw new MyException("Invalid amount!");
			if (expirationDate.compareTo(currentDate) < 0)
				throw new MyException("Your account has expired in" + expirationDate + " !");
			if (amount > limit)
				throw new MyException("You can not withdraw more than " + limit + " !");
			if (amount > this.getMoney())
				throw new MyException("You do not have enough money.Account ballance:" + this.getMoney() + " .");
			this.setMoney(this.getMoney() - amount);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

	public String checkDeposit(LocalDate date) {
		return "Your account balance is " + this.getMoney();
	}
}
