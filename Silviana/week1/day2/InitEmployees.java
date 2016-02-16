package pack2;

import java.util.ArrayList;

public class InitEmployees {

	public static ArrayList<Employee> employees;
	public static ArrayList<Employee> theExistingEmployees()
	{
		employees= new ArrayList<Employee>();
	    employees.add(new Employee(1, "ana", "ana","2950715080023"));
	    employees.add(new Employee(2, "mirela", "irimia","2900825080034"));
	    employees.add(new Employee(3, "ion", "agripinei","2860420080034"));
	    employees.add(new Employee(4, "viorel", "anghel","2980803080033"));
		
		return employees;
	}
	
}
