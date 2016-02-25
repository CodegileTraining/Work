import java.util.GregorianCalendar;

public class NormalAccount extends Account {

	private final int maxsum;

	public NormalAccount(int id, int currentSum, GregorianCalendar createDate, int maxsuM) {
		super(id, currentSum, createDate);
		maxsum = maxsuM;
	}

	@Override
	public String toString() {
		return "NormalAccount [maxsum=" + maxsum + ", ID=" + getID() + ", CurrentSum=" + getCurrentSum()
				+ ", CreateDate=" + getCreateDate().getTime() + "]";
	}

	public int getMaxsum() {
		return maxsum;
	}

	@Override
	public void getMoney(int sum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void putMoney() {
		// TODO Auto-generated method stub

	}

}
