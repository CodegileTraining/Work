package pack;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TermenAccount extends Account {

	private final int dueDate = 24;
	private final double interest = 0.03;
	private LocalDate lastUpdate;

	public TermenAccount(LocalDate accountDate, double ammountOfMoney) {
		super(accountDate, ammountOfMoney);
		lastUpdate = accountDate;
	}

	private void calcInterest() {
		LocalDate currentDate = LocalDate.now();
		double daysSinceUpdate = (double) ChronoUnit.DAYS.between(lastUpdate, currentDate);
		setAmmountOfMoney(getAmmountOfMoney() + daysSinceUpdate * interest * getAmmountOfMoney());
		lastUpdate = LocalDate.now();
	}

	@Override
	public void deposit(double suma) {
		try {
			if (suma <= 0) {
				throw new Exception("Suma depusa trebuie sa fie un numar pozitiv!");
			}
			calcInterest();
			setAmmountOfMoney(getAmmountOfMoney() + suma);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void extraction(double suma) {

		LocalDate currentDate = LocalDate.now();
		try {
			if (suma <= 0) {
				throw new Exception("Suma extrasa trebuie sa fie un numar pozitiv!");
			}
			if (suma > getAmmountOfMoney()) {
				throw new Exception("Suma introdusa este mai mare decat suma de bani existenta in cont");
			}
			if (currentDate.getDayOfMonth() != (dueDate)) {
				throw new Exception("Data curenta nu corespude cu data stabilita!");
			}

			calcInterest();
			setAmmountOfMoney(getAmmountOfMoney() - suma);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public String toString() {
		return "TermenAccount [getAccountDate()=" + getAccountDate() + ", getAmmountOfMoney()=" + getAmmountOfMoney()
				+ ", dueDate=" + dueDate + ", interest=" + interest + "]";
	}

}
