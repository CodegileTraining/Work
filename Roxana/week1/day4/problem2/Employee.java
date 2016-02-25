package inst;

import java.util.ArrayList;

/**
 * Represents an employee enrolled in the institution. An employee can be
 * Director, Manager or Secretary. An employee can receive different gifts.
 * 
 * @author Roxana
 */
public class Employee {
	private String name;
	private String description;
	private ArrayList<Gift> gifts = new ArrayList<Gift>();

	/**
	 * Creates a new Employee.
	 * 
	 * @param description
	 *            Employee type description
	 * @param name
	 *            Employee type name
	 */
	public Employee(String description, String name) {

		this.description = description;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return description + " - " + name;
	}

	/**
	 * Displaying gifts for each employee
	 *
	 */
	public void printGifts() {
		System.out.println(this);
		for (Gift g : gifts) {
			System.out.println(g.getDescription() + " " + g.getYear() + "-" + g.getMonth());
		}
		System.out.println();
	}

	/**
	 * Adds a {@link Gift} to the gifts list.
	 * 
	 * @param a
	 *            Gift to be added to the list
	 */
	public void addGift(Gift a) {
		gifts.add(a);
	}

	public ArrayList<Gift> getGifts() {
		return gifts;
	}
}
