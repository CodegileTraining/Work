import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerCRUD implements CRUDCustomer {

	List<Customer> custList = new ArrayList<Customer>();

	@Override
	public void create(Customer c) {

		custList.add(c);
	}

	@Override
	public Customer read(Scanner input) {

		String[] words = input.nextLine().split(",");
        Customer c=new Customer(Integer.parseInt(words[0]), words[1], words[2]);
		return c;
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		custList.remove(index);
	}

}
