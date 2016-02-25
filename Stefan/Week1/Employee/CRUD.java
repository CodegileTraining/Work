import java.util.Scanner;

public interface CRUD {

	public void create(Employee e);
	public Employee read(Scanner input);
	public void update(int id);
	public int delete(int index);
}
