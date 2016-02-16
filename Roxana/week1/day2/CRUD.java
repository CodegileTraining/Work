import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

	private  ArrayList<Employee> employee = MyClass.init(); ;

	public void read(Employee e) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cod = ");

		e.setId(sc.nextInt());

		System.out.println("Name = ");

		e.setName(sc.next());

		System.out.println("Surname = ");
		e.setSurname(sc.next());

		System.out.println("SSN = ");
		e.setSsn(sc.next());
		
		System.out.println();

	}

	
	public void add(Employee e) {

		employee.add(e);

	}

	public void modify(Employee e) {
		Scanner sc = new Scanner(System.in);
		for (Employee emp : employee) {
			if (emp.equals(e)) {
				System.out.println("cod= ");
				e.setId(sc.nextInt());
				System.out.println("name=");
				e.setName(sc.next());
				System.out.println("surname=");
				e.setSurname(sc.next());
				System.out.println("ssn=");
				e.setSsn(sc.next());
			}
		}
	}

	public void delete(Employee e) {

		for (int i = 0; i < employee.size(); i++) {
			if (employee.get(i).equals(e)) {
				employee.remove(i);
			}

		}

	}
@Override
	public String toString() {
		return "[employee=" + employee + "]";
	}

}
