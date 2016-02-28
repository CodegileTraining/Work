package pack;

import java.util.ArrayList;

public class Client {

	private int id;
	private String name;
	private String ssn;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Client(int id, String name, String ssn) {
		this.id = id;
		this.name = name;
		this.ssn = ssn;

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

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", ssn=" + ssn+"]";
	}

	public void addAccount(Account ac){
		accounts.add(ac);
	}

}
