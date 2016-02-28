
public class Percussion implements Instrument {

	@Override
	public void play() {
		System.out.println("percusion.play()");

	}

	@Override
	public String what() {

		return "Percusion";
	}

	@Override
	public void adjust() {
		System.out.println("Percussion.adjust()");

	}

}
