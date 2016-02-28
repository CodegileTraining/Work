import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Class EmployeeCRUD implements CRUD interface
 * Contains the list of employes 
 * @author Stefan
 *
 */
public class EmployeeCRUD implements CRUD {

	List<Employee> employeeList = new ArrayList<Employee>();
	private String[] words;
	private boolean flag;
/**
 * Add a new employee to the list
 */
	@Override
	public void create(Employee e) {
		// TODO Auto-generated method stub
		if (e != null)
			employeeList.add(e);

	}
/**
 * Read a new employee as a line from a given input 
 * Return an Employee object
 */
	@Override
	public Employee read(Scanner input, String[] emplTypeList) {
		words = input.nextLine().split(",");
		Employee e = null;
		flag = false;
		for (String s : emplTypeList)
			if (s.equals(words[4]))
				flag = true;

		if (!flag)
			System.out.println("Tipul " + words[4] + " nu exista");
		else {
			e = new Employee(Integer.parseInt(words[0]), words[1], words[2], words[3], words[4]);
		}

		return e;
	}
/**
 * Removes an employee from the list 
 */
	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		employeeList.remove(index);
	}

}
