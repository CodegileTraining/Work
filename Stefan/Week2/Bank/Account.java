import java.util.GregorianCalendar;

public abstract class Account {

	private int ID;
	private int currentSum;

	private final GregorianCalendar createDate;

	public Account(GregorianCalendar c) {
		createDate = c;
	}

	public Account(int iD, int currentSum, GregorianCalendar c) {
		super();
		ID = iD;
		this.currentSum = currentSum;

		createDate = c;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCurrentSum() {
		return currentSum;
	}

	public void setCurrentSum(int currentSum) {
		this.currentSum = currentSum;
	}

	public abstract void getMoney(int sum);

	public abstract void putMoney();

	public GregorianCalendar getCreateDate() {
		return createDate;
	}

}
