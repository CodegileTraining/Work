import java.util.ArrayList;
import java.util.Collections;

public class MyClass {

	private static ArrayList<Employee> employee = null;

	public static ArrayList<Employee> init() {

		employee = new ArrayList<Employee>();
		Employee e1 = new Employee(1, "Roxana", "Roxana", "2941102080010");
		employee.add(e1);

		Employee e2 = new Employee(2, " Ion", " Andrei", "2951105070012");
		employee.add(e2);

		return employee;
	}

	public static int nameSurname(Employee e) {

		if (e.getName().equals(e.getSurname()))
			return 1;
		return 0;
	}

	public static int year(Employee e) {

		if (e.getYear(e.getSsn()) >= 80)
			return 1;
		return 0;
	}

	public static void search() {

		for (Employee e : employee) {
			if (nameSurname(e) == 1 && year(e) == 1) {
				System.out.println(e);

			}

		}
	}

	public static void sort() {

		Collections.sort(employee, new ComparatorR());
	}

	public static void main(String[] args) {

		init();
		search();
		sort();
		System.out.println(employee);

		CRUD emp = new CRUD();

		Employee e = new Employee(0, null, null, null);
		System.out.println(emp);
		emp.read(e);
		emp.add(e);
		System.out.println(emp);
		emp.modify(e);
		System.out.println(emp);
		emp.delete(e);
		System.out.println(emp);

	}

}
