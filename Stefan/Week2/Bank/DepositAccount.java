import java.time.LocalDate;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class DepositAccount extends Account {

	private final GregorianCalendar termenDate;

	@SuppressWarnings("unused")
	private static boolean flag = true;

	public DepositAccount(GregorianCalendar c, GregorianCalendar t) {
		super(c);
		termenDate = t;
	}

	public DepositAccount(int ID, int currsumm, GregorianCalendar c, GregorianCalendar termenDate) {
		super(ID, currsumm, c);
		this.termenDate = termenDate;
	}

	@Override
	public String toString() {
		return "DepositAccount [termenDate=" + termenDate.getTime() + ", ID=" + getID() + ", CurrentSum="
				+ getCurrentSum() + ", CreateDate=" + getCreateDate().getTime() + "]";
	}

	public void getMoney(int sum) {

		LocalDate ld = LocalDate.now();
		int result = 100;

		if (ld.getDayOfMonth() < termenDate.get(GregorianCalendar.DAY_OF_MONTH))
			result = JOptionPane.showConfirmDialog(null, "Just do it!! You can do it.. ", null,
					JOptionPane.YES_NO_OPTION);

		if (result == -1 || result == 1) {

		} else {
			flag = false;
			if (sum > 0 && sum < getCurrentSum())
				setCurrentSum(getCurrentSum() - sum);
		}

	}

	@Override
	public void putMoney() {
		// TODO Auto-generated method stub

	}

	public GregorianCalendar getTermenDate() {
		return termenDate;
	}

}
