package problem3;

public class Stringed implements Instrument {

	@Override
	public void play(String note) {
		System.out.println(this+ "is playing note " +note);

	}

	@Override
	public String what() {
		return "Stringled is playing";
	}

	@Override
	public void adjust() {
		System.out.println("Adjust the notes played in class Stringed");

	}

}