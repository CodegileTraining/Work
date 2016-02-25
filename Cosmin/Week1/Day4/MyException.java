package Day4;

/**
 * This class is used to define a custom Exception
 * 
 * @author Margarit
 *
 */
public class MyException extends Exception {

	private static final long serialVersionUID = 1L;

	public MyException(String msg) {
		super(msg);
	}
}
