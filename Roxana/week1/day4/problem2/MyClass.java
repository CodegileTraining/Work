package inst;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyClass {

	static Scanner sc = new Scanner(System.in);
	static Institution inst;

	/**
	 * Monthly gifts report offered to the employees for a year.
	 * 
	 * @param year
	 *            The year in which the gift has been offered
	 */
	public static void reportOfMonths(int year) {
		Map<Integer, ArrayList<Gift>> map = new HashMap<>();

		for (Employee e : inst.getEmployees())
			for (Gift g : e.getGifts())
				if (g.getYear() == year) {
					ArrayList<Gift> current = map.get(g.getMonth());
					if (current == null) {
						current = new ArrayList<Gift>();
					}
					current.add(g);
					map.put(g.getMonth(), current);

				}
		for (int i = 1; i <= 12; i++) {
			ArrayList<Gift> current = map.get(i);
			System.out.println(Month.of(i));
			if (current != null)
				for (Gift g : current) {
					System.out.println(g);
				}
			else
				System.out.println("Doesn`t exist bonuses in this month" + Month.of(i));
			System.out.println();
		}

	}

	/**
	 * Yearly report which contains the employees who have received the most
	 * gifts in a month.
	 * 
	 * @param year
	 *            The year in which the gift has been offered
	 * 
	 */
	public static void giftMax(int year) {
		for (int month = 1; month < 13; month++) {
			Employee max = null;
			int maxNum = -1;
			for (Employee e : inst.getEmployees()) {
				int numGiftsThisMonth = -1;
				for (Gift g : e.getGifts()) {
					if (g.getMonth() == month) {
						numGiftsThisMonth++;
					}
				}
				if (numGiftsThisMonth > maxNum) {
					maxNum = numGiftsThisMonth;
					max = e;
				}
			}
			if (max == null)
				continue;
			System.out.println(Month.of(month));
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		inst = Institution.get();
		inst.initEmployee();

		inst.addGiftToEmployee(inst.getEmployees().get(0), new Coffee(" ", 2016, 2));
		inst.addGiftToEmployee(inst.getEmployees().get(0), new Drink(" ", 2016, 3));
		inst.addGiftToEmployee(inst.getEmployees().get(1), new Coffee(" ", 2016, 5));
		inst.addGiftToEmployee(inst.getEmployees().get(2), new Money(" ", 2016, 1));
		inst.addGiftToEmployee(inst.getEmployees().get(2), new Drink(" ", 2016, 7));
		inst.addGiftToEmployee(inst.getEmployees().get(3), new Money(" ", 2016, 8));
		inst.addGiftToEmployee(inst.getEmployees().get(4), new Money(" ", 2016, 3));
		inst.addGiftToEmployee(inst.getEmployees().get(0), new Coffee(" ", 2016, 9));
		inst.addGiftToEmployee(inst.getEmployees().get(0), new Drink(" ", 2016, 1));
		inst.addGiftToEmployee(inst.getEmployees().get(1), new Coffee(" ", 2016, 11));
		inst.addGiftToEmployee(inst.getEmployees().get(2), new Money(" ", 2016, 1));
		inst.addGiftToEmployee(inst.getEmployees().get(2), new Drink(" ", 2016, 5));
		inst.addGiftToEmployee(inst.getEmployees().get(3), new Money(" ", 2016, 11));
		inst.addGiftToEmployee(inst.getEmployees().get(4), new Money(" ", 2016, 12));

		inst.printEmployees();

		int an;

		System.out.println("Raport ani:");
		System.out.println("Introduceti anul pentru care doriti sa se realizeze raportul: ");
		System.out.println("Anul: ");
		an = sc.nextInt();
		reportOfMonths(an);
		giftMax(2016);

	}

}
