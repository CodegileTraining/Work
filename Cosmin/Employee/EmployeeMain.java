import java.util.ArrayList;

import com.sun.javafx.collections.SortableList;

public class EmployeeMain {

	public static void main(String[] args) {

		ArrayList<Employee> employeeList=Employee.getEmployeeFromFile("employee.txt");
		for(int i=0;i<employeeList.size();i++){
			System.out.println(employeeList.get(i));
			System.out.println("Age: "+employeeList.get(i).getAge());
		}

		employeeList.sort(new CompareEmployee());

		System.out.println("Sort");
		for(int i=0;i<employeeList.size();i++)
		{
			System.out.println(employeeList.get(i));
		}



		//CRUD

		EmployeeCRUD crudList=new EmployeeCRUD();
		System.out.println("CRUD");
		crudList.create(new Employee(10, "Gigel", "Gigel", "6100101987654"));
		crudList.read("employee.txt");
		for(int i=0;i<crudList.getList().size();i++)
			System.out.println(crudList.getList().get(i));
		crudList.update(10, new Employee(10, "Gigel", "Gigelllll", "6100101987654"));
		System.out.println("After CRUD");
		for(int i=0;i<crudList.getList().size();i++)
			System.out.println(crudList.getList().get(i));

	}

}
