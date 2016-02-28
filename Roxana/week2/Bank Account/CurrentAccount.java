package pack;

import java.time.LocalDate;
import java.util.Date;

public class CurrentAccount extends Account {

	private final double maxExtract = 1000;

	public CurrentAccount(LocalDate accountDate, double ammountOfMoney) {
		super(accountDate, ammountOfMoney);

	}

	@Override
	public String toString() {
		return "CurrentAccount" + " [getAccountDate()=" + getAccountDate() + ", getAmmountOfMoney()="
				+ getAmmountOfMoney() + ", maxExtract=" + maxExtract + "]";
	}

	@Override
	public void deposit(double suma) {

		try {
			if (suma <= 0) {
				throw new Exception("Suma depusa trebuie sa fie un numar pozitiv!");
			}
			setAmmountOfMoney(getAmmountOfMoney() + suma);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void extraction(double suma) {

		try {
			if (suma <= 0) {
				throw new Exception("Suma retrasa trebuie sa fie un numar pozitiv!");
			}
			if (suma > getAmmountOfMoney()) {
				throw new Exception("Suma retrasa trebuie sa fie cel mult egata cu suma curenta din cont!");
			}

			if (suma > maxExtract)
				throw new Exception("Este depasita suma maxima!");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

}
