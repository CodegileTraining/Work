package Week2.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

	private static Bank instance;
	private Map<String, List<BankAccount>> accounts;

	private Bank() {
	}

	public void addAccount(BankAccount account) {
		if (accounts == null)
			accounts = new HashMap<>();
		List<BankAccount> list = accounts.get(account.getCustomer().getCnp());
		if (list == null)
			list = new ArrayList<>();
		list.add(account);
		accounts.put(account.getCustomer().getCnp(), list);
	}

	public Map<String, List<BankAccount>> getAccounts() {
		Map<String, List<BankAccount>> accounts = new HashMap<>(this.accounts);
		return accounts;
	}

	public static Bank GetInstance() {
		if (instance == null)
			instance = new Bank();
		return instance;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String s : this.accounts.keySet()) {
			List<BankAccount> accountsList = accounts.get(s);
			for (BankAccount ba : accountsList) {
				sb.append(ba).append("\n");
			}
		}
		return sb.toString();
	}

}
