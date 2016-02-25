import java.text.ParseException;
import java.util.Scanner;

public interface CRUDAccountInterface {

	public void create(Account a);
	public Account read(Scanner input) throws ParseException;
	public void update(Account a,int balance);
	public void delete(int index);
	
}
