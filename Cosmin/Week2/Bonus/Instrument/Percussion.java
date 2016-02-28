package Week2.Instrument;

public class Percussion implements Instrument {

	@Override
	public void play() {

		System.out.println("Percussion.Play");
	}

	@Override
	public String what() {

		return "Percussion.what";
	}

	@Override
	public void adjust() {
		System.out.println("Percussion.Adjust");

	}

}
