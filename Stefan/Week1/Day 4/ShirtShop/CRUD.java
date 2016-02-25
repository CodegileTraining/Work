import java.util.Scanner;

public interface CRUD {

	public void create(Shirt s);
	public Shirt read(Scanner input);
	public void update (int index, int nrBucati);
	public void delete(int index);
}
