package inst;

/**
 * This class is a type of {@link Gift}.
 * 
 * @author Roxana
 *
 */
public class Coffee extends Gift {
	/**
	 * Creates a director type of {@link Gift}.
	 * 
	 * @param description
	 *            Description type Coffee
	 * @param year
	 *            The year in which the Coffee has been offered
	 * @param month
	 *            The month in which the Coffee has been offered
	 */
	public Coffee(String description, int year, int month) {
		super("Pachet de cafea ", year, month);

	}

}
