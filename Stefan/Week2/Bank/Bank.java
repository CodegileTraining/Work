import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {

	private static Bank instance = null;
	private static CustomerCRUD customerList=new CustomerCRUD();
	private static HashMap<Integer,Customer> map=new HashMap<Integer, Customer>();
	

	public static Bank getInstance() {
		if (instance == null)
			instance = new Bank();
		return instance;
	}

	private Bank()  {
		
		try {
			readCustomer();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			readAccounts();
		} catch (NumberFormatException | FileNotFoundException | ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void readAccounts() throws FileNotFoundException, NumberFormatException, ParseException{
		File file=new File("conturi.txt");
		Scanner input =new Scanner(file);
		
		while(input.hasNextLine()){
			String[] words=input.nextLine().split(",");
			
			for (int i=0;i<Integer.parseInt(words[1]);i++){
				Account a= map.get(Integer.parseInt(words[0])).getAccounts().read(input);
				map.get(Integer.parseInt(words[0])).getAccounts().create(a);
			}
				
		}
	}
	public static void readCustomer() throws FileNotFoundException
	{
		
		File file=new File("clienti.txt");
		Scanner input =new Scanner(file);
		
		while(input.hasNextLine()){
			Customer c=customerList.read(input);
			
			map.put(c.getID(), c);
			customerList.create(c);
			
			
		}
		input.close();
	}

	public static CustomerCRUD getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(CustomerCRUD customerList) {
		Bank.customerList = customerList;
	}
}
