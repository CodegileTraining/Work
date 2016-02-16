package pack2;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

	public static ArrayList<Employee> employeesCrud = InitEmployees.theExistingEmployees();
	private static Scanner sc;

	public void readEmployee(Employee e1) {
		sc = new Scanner(System.in);
		e1.setId(sc.nextInt());
		e1.setName(sc.next());
		e1.setSurname(sc.next());
		e1.setSsn(sc.next());
	}

	public void addEmployee(Employee e) {
		employeesCrud.add(e);
	}

	public void modifyEmployee(Employee e) {
		for (Employee i : employeesCrud)
			if (i.equals(e)) {
				i.setId(2);
				i.setName("Cristina");
				i.setSurname("Baciu");
				i.setSsn("2770603080034");
			}
	}

	public void deleteEmployee(Employee e) {
		for (int i = 0; i < employeesCrud.size(); i++)
			if (employeesCrud.get(i).equals(e))
				employeesCrud.remove(i);
	}

}
