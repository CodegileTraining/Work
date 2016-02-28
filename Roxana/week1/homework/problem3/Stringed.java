
public class Stringed implements Instrument {

	@Override
	public void play() {
		System.out.println("Stringed.play()");

	}


	@Override
	public String what() {

		return "Stringed";
	}

	@Override
	public void adjust() {
		System.out.println("Stringed.adjust()");

	}

}
