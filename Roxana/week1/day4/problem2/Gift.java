package inst;

/**
 * Represents a gift that can be offerd to an {@link Employee}.
 * 
 * @author Roxana
 *
 */

public class Gift {

	private int year;
	private int month;
	private String description;
	Employee emp;

	/**
	 * Creates a new gift.
	 * 
	 * @param description
	 *            Description type gift
	 * @param year
	 *            The year in which the gift has been offerd
	 * @param month
	 *            The month in which the gift has been offerd
	 */
	public Gift(String description, int year, int month) {

		this.description = description;
		this.year = year;
		this.month = month;
	}

	@Override
	public String toString() {

		return emp + " a primit " + description + month + "-" + year;

	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public void setEmployee(Employee e) {
		emp = e;
	}

	public Employee getEmployee() {
		return emp;
	}

	public String getDescription() {
		return description;
	}

}
