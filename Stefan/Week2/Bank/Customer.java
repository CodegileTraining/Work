
public class Customer {

	private int ID;
	private String Name;
	private String CNP;
	private AccountCRUD Accounts=new AccountCRUD();

	public void afisareAccounts() {
		for (Account a : Accounts.accList)
			System.out.println(a);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public Customer(int iD, String name, String cNP) {
		super();
		ID = iD;
		Name = name;
		CNP = cNP;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", Name=" + Name + ", CNP=" + CNP + "]";
	}

	public AccountCRUD getAccounts() {
		return Accounts;
	}

	public void setAccounts(AccountCRUD accounts) {
		Accounts = accounts;
	}

}
