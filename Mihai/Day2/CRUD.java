import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CRUD {
	HashMap<Integer, Employee> list;

	public CRUD() {

		list = new HashMap<Integer, Employee>();

	}

	public void create(Employee ob) {

		list.put(ob.getID(), ob);
	}

	public Employee read() {
		System.out.println("Enter ID");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		System.out.println("Enter SSN");
		long SSN = sc.nextLong();
		System.out.println("Enter name");
		String n = sc.next();
		System.out.println("Enter surname");
		String n1 = sc.next();
		Employee ob = new Employee(id, SSN, n, n1);
		return ob;
	}

	public void delete(int id) {
		list.remove(id);
	}

	public void update(int id) {
		Employee ob = list.get(id);
		System.out.println("What do you want to modify:\n 1.Id\n2.SSN\n3.Name\n4.Surname");
		Scanner sc = new Scanner(System.in);
		switch (sc.nextInt()) {
		case 1:
			ob.setID(sc.nextInt());
			break;
		case 2:
			ob.setSSN(sc.nextLong());
			break;
		case 3:
			ob.setName(sc.next());
			break;
		case 4:
			ob.setSurnname(sc.next());
			break;
		}
	}

	public static void main(String[] arg) {
		CRUD ob = new CRUD();
		int x = 1;
		while ( true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("what do you want to do:\n1.Add Employee\n2.Update Employee\n3.Remove Employee\n4.Exit");
			x = sc.nextInt();
			switch (x) {
			case 1:
				ob.create(ob.read());
				break;
			case 2:
				System.out.println("Enter ID");
				ob.update(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter ID");
				ob.delete(sc.nextInt());
				break;
			case 4:
				System.exit(0);
			}
		}

	}
}
