
public class Wind implements Instrument {

	@Override
	public void play() {
		System.out.println("wind.play()");

	}

	@Override
	public String what() {

		return "Wind";
	}

	@Override
	public void adjust() {
		System.out.println("wind.adjust()");

	}

}
