package pack;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Bank bank = Bank.get();
		bank.initClients();
		bank.printClients();
		ArrayList<Client> clients = bank.getClients();

		Account ac1 = bank.getAccounts().get(0);
		Account ac2 = bank.getAccounts().get(1);
		Account ac3 = bank.getAccounts().get(2);

		ac1.deposit(200);
		ac1.extraction(400);
		System.out.println(ac1);
		ac1.extraction(150);
		System.out.println(ac1);

		ac2.deposit(300);
		ac2.extraction(900);
		System.out.println(ac2);

		ac3.deposit(300);
		
		ac3.extraction(1200);
		System.out.println(ac3);

	}

}
