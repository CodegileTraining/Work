package inst;

/**
 * This class is a type of {@link Gift}.
 * 
 * @author Roxana
 *
 */
public class Drink extends Gift {
	/**
	 * Creates a director type of {@link Gift}.
	 * 
	 * @param description
	 *            Description type Drink
	 * @param year
	 *            The year in which the Drink has been offered
	 * @param month
	 *            The month in which the Drink has been offered
	 */
	public Drink(String description, int year, int month) {
		super("Sampanie ", year, month);

	}

}
