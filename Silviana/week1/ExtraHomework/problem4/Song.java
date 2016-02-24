package problem4;

public interface Song {

	/**
	 * Interface variables are static because Java interfaces cannot be
	 * instantiated in their own right; the value of the variable must be
	 * assigned in a static context in which no instance exists. The final
	 * modifier ensures the value assigned to the interface variable is a true
	 * constant that cannot be re-assigned by program code.
	 */

	int minutes = 3;
	String[] artists = { "John", "Carl", "Joshua" };

	void howManyMinutes();

	void whoIsPlaying();
}
