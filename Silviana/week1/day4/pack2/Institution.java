package pack2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Institution {

	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private Scanner sc;

	private static Institution instance;

	private Institution() {

	}
/**
 * 		Creates a single instance of this class.
 * @return
 */
	public static Institution getInstance() {
		if (instance == null) {
			instance = new Institution();
		}
		return instance;
	}
/**
 * 		All the employees will be read from a file and introduced in an ArrayList after the type of the employees.
 */
	public void readEmployees() {
		File in = new File("fisier.txt");
		try {
			sc = new Scanner(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int numberEmployees = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numberEmployees; i++) {
			String line = sc.nextLine();
			String type = line.substring(0, line.indexOf(" "));
			String name = line.substring(line.indexOf(" ") + 1);

			EmployeeTypes eType = EmployeeTypes.valueOf(type);

			switch (eType) {
			case MANAGER:
				employees.add(new Manager(name));
				break;
			case CEO:
				employees.add(new CEO(name));
				break;
			case SECRETARY:
				employees.add(new Secretary(name));
				break;

			}
		}
	}

	/**
	 * 		This function reads the bonuses which has been received by every single employee from the @Institution.
	 */
	public void addBonusForEmployees() {

		for (Employee e : employees) {
			int nrBonuses;

			nrBonuses = sc.nextInt();
			sc.nextLine();

			for (int i = 0; i < nrBonuses; i++) {
				String line = sc.nextLine();
				String[] parts = line.split(" ");
				String type = parts[0];
				int pieces = Integer.parseInt(parts[1]);
				String data = parts[2];

				BonusTypes bType = BonusTypes.valueOf(type);

				Bonus b;
				switch (bType) {
				case COFFEE:
					b = new Coffee(pieces, data);
					b.setOwner(e);
					e.addBonus(b);
					break;
				case CHOCOLATE:
					b = new Chocolate(pieces, data);
					b.setOwner(e);
					e.addBonus(b);
					break;
				case EXTRAMONEY:
					b = new ExtraMoney(pieces, data);
					b.setOwner(e);
					e.addBonus(b);
					break;
				}
			}
		}
	}

	/**
	 * 		This function is printing the employees.
	 */
	public void printEmployees() {
		for (Employee e : employees)
			System.out.println(e);
		System.out.println();
		System.out.println();
	}

	/**
	 * 		Prints the monthly report of the bonuses from @Bonus which was receive by de employees from @Employee.
	 * @param year
	 * 		Will be printed the report for this year.
	 * @param monthlyBonuses
	 *      This parameter will contain the bonuses received in every month of the @year received as a parameter.
	 * 		
	 */
	public void printMonthlyReport(int year, HashMap<Integer, ArrayList<Bonus>> monthlyBonuses)

	{
		System.out.println("Report for year " + year);
		System.out.println();
		for (int month = 1; month <= 12; month++) {
			ArrayList<Bonus> currentBonuses = monthlyBonuses.get(month);
			if (currentBonuses == null) {
				continue;
			}

			System.out.println(Month.values()[month - 1]);

			for (Bonus b : currentBonuses) {
				System.out.println(b.getOwner().getFullname() + " has received " + b.getPieces() + " pieces of "
						+ b.getDescription() + " at " + b.getData());
			}
			System.out.println();
		}
	}

	/**
	 * 		Calculates the bonuses received in every month of the @year and returns them as a HashMap<Integer, ArrayList<Bonus>>. 
	 * @param year
	 * 		The year for which we make the report.
	 * @return
	 */
	public HashMap<Integer, ArrayList<Bonus>> getMonthlyReport(int year) {
		HashMap<Integer, ArrayList<Bonus>> monthlyBonuses = new HashMap<>();

		for (Employee e : employees) {
			ArrayList<Bonus> auxBonuses = e.getBonuses();

			for (Bonus b : auxBonuses) {
				String[] parts = b.getData().split("/");
				int month = Integer.parseInt(parts[1]);
				int y = Integer.parseInt(parts[2]);

				if (year != y) {
					continue;
				}

				ArrayList<Bonus> selectedBonuses = monthlyBonuses.get(month);

				if (selectedBonuses == null) {
					selectedBonuses = new ArrayList<Bonus>();
				}

				selectedBonuses.add(b);
				monthlyBonuses.put(month, selectedBonuses);
			}
		}

		return monthlyBonuses;
	}

	/**
	 * 		Calculates the most bonused employee of each month of the @year.
	 * @param year
	 * 		The year for which we make the report.
	 * @param monthlyBonuses
	 * 		The bonuses received in every month of the @year.
	 * 		
	 */
	public void getEmployeeWithMostBonuses(int year, HashMap<Integer, ArrayList<Bonus>> monthlyBonuses) {

		getMonthlyReport(year);

		System.out.println();
		System.out.println("The situation of most bonused employees of the year " + year + " per months: ");
		System.out.println();

		for (int month = 1; month <= 12; month++) {

			ArrayList<Bonus> current = monthlyBonuses.get(month);
			if (current == null) {
				continue;
			}

			Employee mostBonusedEmployee = new Employee();
			int maxPiecesOfBonuses = 0;

			System.out.println(Month.values()[month - 1]);
			for (Employee e : employees) {
				int piecesOfBonuses = 0;
				for (Bonus b : current) {

					if (e.equals(b.getOwner())) {
						piecesOfBonuses += b.getPieces();
					}

					if (piecesOfBonuses > maxPiecesOfBonuses) {
						maxPiecesOfBonuses = piecesOfBonuses;
						mostBonusedEmployee = e;
					}
				}

			}
			System.out.println("Most bonused employee of the month is " + mostBonusedEmployee.getFullname()
					+ ". He/She received " + maxPiecesOfBonuses + " bonuses.");
		}

	}

}
