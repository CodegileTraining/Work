import java.util.Scanner;

public interface CRUD {

	public void create(Produs p);
	public Produs read(Scanner input);
	public void update(int index);
	public void delete(int index);
}
