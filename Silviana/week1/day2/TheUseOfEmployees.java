package pack2;

import java.util.ArrayList;
import java.util.Collections;

public class TheUseOfEmployees {

	public static void main(String[] args) {
		
		ArrayList<Employee> empl = InitEmployees.theExistingEmployees();
		verifyEqualityOfNamesAndDateOfBirth(empl);
		
		System.out.println("Dupa sortare: ");
		Collections.sort(empl, new ComparatorAge());
		for (int i = 0; i < empl.size(); i++)
			System.out.println(empl.get(i));

		CRUD emplo = new CRUD();
		Employee human;
		emplo.readEmployee(human = new Employee(0, null, null, null));
		emplo.addEmployee(human);
		System.out.println(CRUD.employeesCrud);

		emplo.modifyEmployee(human);
		System.out.println(CRUD.employeesCrud);

		emplo.deleteEmployee(human);
		System.out.println(CRUD.employeesCrud);

	}

	public static void verifyEqualityOfNamesAndDateOfBirth(ArrayList<Employee> empl) {
		for (int i = 0; i < empl.size(); i++)
			if (empl.get(i).getName().equals(empl.get(i).getSurname())) {
				if (empl.get(i).getYear(empl.get(i).getSsn()) > 80) {
					System.out.println(empl.get(i));
				}
			}

	}

}
