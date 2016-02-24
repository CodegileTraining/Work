package accounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bank {

	private static Bank instance;
	private ArrayList<Client> clients = new ArrayList<Client>();
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private Scanner sc;

	private Bank() {
	}

	public static Bank getInstance() {
		if (instance == null) {
			instance = new Bank();
		}
		return instance;
	}

	public void readClients() {

		File file = new File("fileaccount.txt");
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int numberClients = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numberClients; i++) {

			ArrayList<Account> clientAccounts = new ArrayList<Account>();

			String line = sc.nextLine();
			String[] parts = line.split(",");
			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			String ssn = parts[2];

			int numberOfAccounts = Integer.parseInt(parts[3]);

			for (int j = 0; j < numberOfAccounts; j++) {

				String accLine = sc.nextLine();
				String[] accParts = accLine.split(",");
				String accType = accParts[0];
				double existingMoney = Double.parseDouble(accParts[1]);
				DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
				Date creationDate = null;

				try {
					creationDate = date.parse(accParts[2]);

				} catch (ParseException e) {
					e.printStackTrace();
				}

				AccountTypes types = AccountTypes.valueOf(accType);

				switch (types) {
				case CURRENTACCOUNT:
					clientAccounts.add(new CurrentAccount(existingMoney, creationDate));
					break;
				case FIXEDDAYACCOUNT:
					double interest = Double.parseDouble(accParts[3]);
					clientAccounts.add(new FixedDayAccount(existingMoney, creationDate, interest));
					break;

				}
			}

			clients.add(new Client(id, name, ssn, clientAccounts));
			accounts.addAll(clientAccounts);
		}
	}

	public void printClients() {
		for (Client c : clients) {
			System.out.println(c);
			for (Account a : c.getAccounts())
				System.out.println(a);
		}
		System.out.println();
		System.out.println();
	}

	public void addNewAccount(Client client, String typeAccount, int newMoneyInNewAccount, Date newCreationDate,
			double newInterest) {
		AccountTypes type = AccountTypes.valueOf(typeAccount);
		Account a = null;
		switch (type) {
		case FIXEDDAYACCOUNT:
			a = new FixedDayAccount(newMoneyInNewAccount, newCreationDate, newInterest);
			break;
		case CURRENTACCOUNT:
			a = new CurrentAccount(newMoneyInNewAccount, newCreationDate);
			break;

		}
		accounts.add(a);
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

}
