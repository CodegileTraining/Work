package Week3.ExceptionsCodegile.src.com.example.exceptions;

public class InvalidEmployeeIDException extends ArrayIndexOutOfBoundsException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeIDException(int id) {
		super("Invalid employee id"+id);
	}
}
