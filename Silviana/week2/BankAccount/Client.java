package accounts;

import java.util.ArrayList;

public class Client {
	private int id;
	private String name;
	private String ssn;
	private ArrayList<Account> accounts;
	public Client(int id, String name, String ssn,ArrayList<Account> accounts) {
		this.id = id;
		this.name = name;
		this.ssn = ssn;
		this.accounts=accounts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	@Override
	public String toString() {
		return "Client [ " + id + " , " + name + " , " + ssn+ " ]";
	}
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	

}
