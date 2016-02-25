import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeCRUD implements CRUD {

	List<Employee>employeeList=new ArrayList<Employee>();
	@Override
	public void create(Employee e) {
		// TODO Auto-generated method stub
		employeeList.add(e);
		
	}

	@Override
	public Employee read(Scanner input) {
		// TODO Auto-generated method stub
		Employee object=new Employee();
		String myLine=input.nextLine();
		
		String[] words=myLine.split(",");
		object.setAll(words[0],words[1],words[2],words[3]);
		return object;
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(int index) {
		// TODO Auto-generated method stub
		employeeList.remove(index);
		return 0;
	}
	
	
}
