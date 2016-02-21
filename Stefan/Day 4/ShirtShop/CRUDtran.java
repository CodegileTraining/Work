import java.util.HashMap;
import java.util.Scanner;

public interface CRUDtran {

	public void create(Transaction t);
	public Transaction read(Scanner input,HashMap <Integer, Shirt> map) throws Exception;
	public void update(int index);
	public void delete(int index);
}
