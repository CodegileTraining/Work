package Week2.Bank;

import java.time.LocalDate;
import java.time.Month;

import Week2.Bank.NormalAccount;

public class BankMain {

	public static void main(String[] s) {

		Customer c1 = new Customer("1950829098765", "Samson Gica");
		Customer c2 = new Customer("1950421076545", "Cosmin");

		Bank bank = Bank.GetInstance();

		BankAccount ac1 = new DepozitAccount(c1, 123.9, LocalDate.of(2016, Month.FEBRUARY, 21),
				LocalDate.of(2017, Month.APRIL, 21), 27, (float) 4.6);
		BankAccount ac2 = new DepozitAccount(c2, 2354.9, LocalDate.of(2016, Month.FEBRUARY, 21),
				LocalDate.of(2017, Month.APRIL, 21), 27, (float) 4.6);
		BankAccount ac3 = new NormalAccount(c1, 1237421.44, LocalDate.now(), LocalDate.of(2020, Month.DECEMBER, 23));
		BankAccount ac4 = new NormalAccount(c2, 87981.44, LocalDate.now(), LocalDate.of(2015, Month.DECEMBER, 23));

		bank.addAccount(ac1);
		bank.addAccount(ac2);
		bank.addAccount(ac3);
		bank.addAccount(ac4);

		System.out.println(bank);
		System.out.println();
		System.out.println(bank);
	}
}
