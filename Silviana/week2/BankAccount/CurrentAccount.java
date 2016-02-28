package accounts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentAccount extends Account {

	private final double extractedMoney = 200;

	public CurrentAccount(double existingMoney, Date creationDate) {
		super(existingMoney, creationDate);
		// TODO Auto-generated constructor stub
	}

	public double getExtractedMoney() {
		return extractedMoney;
	}

	@Override
	public void addDeposit(int newMoney) throws InvalidSumOfMoneyException {

		if (newMoney != 0)
			this.setExistingMoney(this.getExistingMoney() + newMoney);
		else
			throw new InvalidSumOfMoneyException("You haven't introduced any money!");

	}

	@Override
	public void addExtraction(int newMoney) throws InvalidSumOfMoneyException {
		if (newMoney > this.getExistingMoney())
			throw new InvalidSumOfMoneyException("You didn't have that sum of money in your account!");
		if (newMoney > extractedMoney)
			throw new InvalidSumOfMoneyException("You cannot extract so much money!");
		else
			this.setExistingMoney(this.getExistingMoney() - newMoney);

	}

	@Override
	public String toString() {
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		return "CurrentAccount [ " + getExistingMoney() + " , " + date.format(getCreationDate()) + " , "
				+ extractedMoney + " ]";
	}

}
