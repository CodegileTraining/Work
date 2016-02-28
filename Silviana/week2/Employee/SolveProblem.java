package employeehw;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class SolveProblem {
	public static void main(String[] args) {
		TheFirm firm = new TheFirm();
		ArrayList<Employee> employees = new ArrayList<Employee>();

		firm.readEmployees();
		firm.printEmployees();

		System.out.println("The employees after the salary sort of Managers:");
		System.out.println();
		Collections.sort(employees, new SalaryComparator());
		firm.printEmployees();

		System.out.println("The employees after the raise of salary for Directors:");
		System.out.println();
		firm.raiseSalaryForDirectors();
		firm.printEmployees();

		System.out.println("The employees after the raise of salary for woman Managers: ");
		System.out.println();
		firm.raiseSalaryForWomanManagers(1000);
		firm.printEmployees();

		int nr = firm.getover30ManDirectors(Calendar.getInstance().get(Calendar.YEAR));
		System.out.println("Number of > 30 directors: " + nr);
	}
}
