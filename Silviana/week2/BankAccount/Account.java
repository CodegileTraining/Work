package accounts;

import java.util.Date;

public abstract class Account {

	private double existingMoney;
	private Date creationDate;

	public abstract void addDeposit(int newMoney) throws InvalidSumOfMoneyException;

	public abstract void addExtraction(int newMoney) throws InvalidSumOfMoneyException, DueDayViolationException;

	public Account(double existingMoney, Date creationDate) {
		this.existingMoney = existingMoney;
		this.creationDate = creationDate;
	}

	public double getExistingMoney() {
		return existingMoney;
	}

	public void setExistingMoney(double existingMoney) {
		this.existingMoney = existingMoney;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Account [ " + existingMoney + " , " + creationDate + " ]";
	}

}
