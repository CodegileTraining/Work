package pack;

import java.time.LocalDate;
import java.util.Date;

public abstract class Account {

	private LocalDate accountDate;

	private double ammountOfMoney;
	

	public LocalDate getAccountDate() {
		return accountDate;
	}

	public double getAmmountOfMoney() {
		return ammountOfMoney;
	}

	public Account(LocalDate accountDate, double ammountOfMoney) {

		this.accountDate = accountDate;
		this.setAmmountOfMoney(ammountOfMoney);

	}

	public void setAmmountOfMoney(double ammountOfMoney) {
		this.ammountOfMoney = ammountOfMoney;

	}

	public abstract void deposit(double suma);

	public abstract void extraction( double suma);

	

}
