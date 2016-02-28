package inst;

public class Money extends Gift {
	/**
	 * Creates a director type of {@link Gift}.
	 * 
	 * @param description
	 *            Description type Money
	 * @param year
	 *            The year in which the Money has been offered
	 * @param month
	 *            The month in which the Money has been offered
	 */
	public Money(String description, int year, int month) {
		super("Voucher in valoare de 50Lei ", year, month);

	}

}
