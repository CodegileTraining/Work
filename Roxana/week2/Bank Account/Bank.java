package pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bank {

	private static Bank bank;
	private ArrayList<Client> clients = new ArrayList<Client>();
	private ArrayList<Account> accounts = new ArrayList<>();

	private Bank() {
	}

	public static Bank get() {
		if (bank == null) {
			bank = new Bank();
		}
		return bank;
	}


	public void initClients() {

		File file = new File("fisier");
		Scanner fsc = null;
		try {
			fsc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		while (fsc.hasNextLine()) {
			String line = fsc.nextLine();
			String[] splitLine = line.split(", ");
			int id = Integer.parseInt(splitLine[0]);
			String name = splitLine[1];
			String ssn = splitLine[2];
			Client client = new Client(id, name, ssn);

			int numAccounts = fsc.nextInt();
			fsc.nextLine();

			for (int i = 0; i < numAccounts; i++) {
				String account = fsc.nextLine();
				String[] splitAccount = account.split("-");
				String typeAccount = splitAccount[0];
				String date = splitAccount[1];
				String[] splitDate = date.split("/");
				int year = Integer.parseInt(splitDate[2]);
				int month = Integer.parseInt(splitDate[1]);
				int day = Integer.parseInt(splitDate[0]);
				LocalDate dateAccount = LocalDate.of(year, month, day);

				double amountOfMoney = Double.parseDouble(splitAccount[2]);

				Account ac = null;
				
				switch (typeAccount) {

				case "Current Account":
					ac = new CurrentAccount(dateAccount, amountOfMoney);
					break;
				case "Termen Account":
					ac = new TermenAccount(dateAccount, amountOfMoney);
				default:
				}
				client.addAccount(ac);
				accounts.add(ac);

			}
			clients.add(client);

		}

	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public static Bank getBank() {
		return bank;
	}

	public void printClients() {
		for (Client c : clients) {
			System.out.println(c);

			for (Account ac : c.getAccounts())
				System.out.println(ac);
			System.out.println();
		}
	}

}
