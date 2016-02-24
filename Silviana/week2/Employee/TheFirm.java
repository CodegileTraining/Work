package employeehw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

public class TheFirm {

	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private static Scanner sc;

	public void readEmployees() {
		File in = new File("file.txt");
		try {
			sc = new Scanner(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int numberEmployees = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numberEmployees; i++) {
			String line = sc.nextLine();
			String[] parts = line.split(",");
			String type = parts[0];
			int id = Integer.parseInt(parts[1]);
			String name = parts[2];
			String cnp = parts[3];
			double salary = Double.parseDouble(parts[4]);

			EmployeeTypes eType = EmployeeTypes.valueOf(type);

			switch (eType) {
			case ADMIN:
				employees.add(new Admin(id, name, cnp, salary));
				break;
			case ENGINEER:
				employees.add(new Engineer(id, name, cnp, salary));
				break;
			case MANAGER:
				String depName = parts[5];
				employees.add(new Manager(id, name, cnp, salary, depName));
				break;
			case DIRECTOR:
				String depName1 = parts[5];
				double budget = Double.parseDouble(parts[6]);
				employees.add(new Director(id, name, cnp, salary, depName1, budget));
				break;
			}

		}
	}

	public void printEmployees() {
		for (Employee e : employees)
			System.out.println(e.toString());
		System.out.println();
		System.out.println();
	}

	public void raiseSalaryForDirectors() {
		for (Employee e : employees)
			if (e instanceof Director)
				e.setSalary(e.getSalary() + ((Director) e).getBudget() / 2);
	}

	public void raiseSalaryForWomanManagers(int raiseSum) {
		for (Employee e : employees)
			if (e instanceof Manager)
				if (((Manager) e).getDepName().equals("IT"))
					if (e.getCnp().charAt(0) == '2') {
						e.setSalary(e.getSalary() + raiseSum);

					}
	}

	public int getover30ManDirectors(int currentYear) {
		int nrOver30Directors = 0;
		for (Employee e : employees)
			if (e instanceof Director)
				if (e.getCnp().charAt(0) == '1') {

					int x = Character.getNumericValue(e.getCnp().charAt(1));
					int y = Character.getNumericValue(e.getCnp().charAt(2));
					int birthYear = 1900 + x * 10 + y;
					if (currentYear - birthYear > 30)
						nrOver30Directors++;
				}
		return nrOver30Directors;
	}

}
