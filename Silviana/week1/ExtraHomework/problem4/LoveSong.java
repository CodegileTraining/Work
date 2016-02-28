package problem4;

public class LoveSong implements Song {

	/**
	 * We cannot modify minutes like this: minutes=7;
	 * This field is static and final, so the value 3 of the minutes will be seen from every class which implements @Song
	 */
	public void howManyMinutes() {
		System.out.println("The song have " + minutes + " minutes.");

	}

	public void whoIsPlaying() {
		System.out.print("The singers are: ");
		for (int i = 0; i < artists.length; i++)
			System.out.print(artists[i] + "  ");
	}

}
