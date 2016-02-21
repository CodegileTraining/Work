import java.util.Scanner;
/**
 *EmployeeCRUD  Interface 
 * @author Stefan
 *
 */
public interface CRUD {

	public void create(Employee e);
	public Employee read(Scanner input,String[] emplTypeList);
	public void delete(int index);
}
