import java.util.Scanner;

public interface CRUDCustomer {

	public void create(Customer c);
	public Customer read(Scanner Input);
	public void delete(int index);
	
}
