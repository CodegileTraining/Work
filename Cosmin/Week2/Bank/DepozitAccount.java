package Week2.Bank;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import Day4.MyException;

public class DepozitAccount extends BankAccount {

	private static boolean interestFlag = true;
	private LocalDate expirationDate;
	private final int interestDay;
	private final float interest;

	public DepozitAccount(Customer customer, double money, LocalDate date, LocalDate expDate, int interestDate,
			float interest) {
		super(customer, money, date);
		this.expirationDate = expDate;
		this.interestDay = interestDate;
		this.interest = interest;
	}

	public int getExpirationDate() {
		return interestDay;
	}

	public float getInterest() {
		return interest;
	}

	public void deposit(double amount) {
		LocalDate currentDate = LocalDate.now();
		System.out.println(this.getMoney());
		try {
			if (amount < 0)
				throw new MyException("Invalid amount!");
			if (expirationDate.compareTo(currentDate) < 0)
				throw new MyException("Your account has expired in" + expirationDate + " !");
			this.setMoney(amount + this.getMoney());
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(this.getMoney());
	}

	public void withdraw(double amount) {
		LocalDate currentDate = LocalDate.now();
		int result = 4;
		try {
			if (amount < 0)
				throw new MyException("Invalid amount!");
			if (expirationDate.compareTo(currentDate) < 0)
				throw new MyException("Your account has expired in" + expirationDate + " !");
			if (currentDate.getDayOfMonth() < interestDay) {
				result = JOptionPane.showConfirmDialog(null,
						"If you withdraw now the interest will be lost.Are you sure?", null, JOptionPane.YES_NO_OPTION);
			}
			if (amount > this.getMoney())
				throw new MyException("You do not have enough money.Account ballance:" + this.getMoney() + " .");
			if (result != 1) {
				this.setMoney(this.getMoney() - amount);
				if (result == 0)
					interestFlag = false;
			}
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

	public String checkDeposit(LocalDate date) {
		if (date.getDayOfMonth() > interestDay && interestFlag)
			this.setMoney(this.getMoney() + (interest / 100) * this.getMoney());
		else if (date.getDayOfMonth() > interestDay && !interestFlag)
			interestFlag = true;
		return "Your account balance is " + this.getMoney();
	}
}
