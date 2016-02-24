package problem3;

public class Wind implements Instrument {

	@Override
	public void play(String note) {
		System.out.println(this +" is playing note "+note);

	}

	@Override
	public String what() {
		return "Wind is playing";
	}

	@Override
	public void adjust() {
		System.out.println("Adjust the notes played in class Wind");

	}

}
