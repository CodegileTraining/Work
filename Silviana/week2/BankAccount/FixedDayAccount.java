package accounts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FixedDayAccount extends Account {

	private final int dueDate = 27;
	private double interest;

	public FixedDayAccount(double existingMoney, Date creationDate, double interest) {
		super(existingMoney, creationDate);
		this.interest = interest;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getDueDate() {
		return dueDate;
	}

	@Override
	public void addDeposit(int newMoney) throws InvalidSumOfMoneyException {
		if (newMoney != 0) {
			this.setExistingMoney(this.getExistingMoney() + (interest / 100) * this.getExistingMoney());
			this.setExistingMoney(this.getExistingMoney() + newMoney);
		} else
			throw new InvalidSumOfMoneyException("You haven't introduced any money!");

	}

	@SuppressWarnings("deprecation")
	@Override
	public void addExtraction(int newMoney) throws DueDayViolationException, InvalidSumOfMoneyException {
		Date timeNow = new Date();
		if (newMoney > this.getExistingMoney())
			throw new InvalidSumOfMoneyException("You didn't have that sum of money in your account!");
		if (timeNow.getDay() != dueDate)
			throw new DueDayViolationException("You cannot extract money today! You will lose the interest!");
		else {
			this.setExistingMoney(this.getExistingMoney() + (interest / 100) * this.getExistingMoney());
			this.setExistingMoney(this.getExistingMoney() - newMoney);
		}

	}

	@Override
	public String toString() {
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		return "FixedDayAccount [" + getExistingMoney() + " , " + date.format(getCreationDate()) + " , " + dueDate
				+ " , " + interest + "]";
	}

}
