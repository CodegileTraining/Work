
public class BancaMain {

	private static Bank banca;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bank.getInstance();
		for (Customer c:Bank.getCustomerList().custList){
			System.out.println(c);
			c.afisareAccounts();
		}
		
	}

	public static Bank getBanca() {
		return banca;
	}

	

}
