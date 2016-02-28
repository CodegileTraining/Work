
public class Guitar implements Instrument {

	@Override
	public void play() {
		System.out.println("Guitar.play");
		
	}

	@Override
	public void nrStrings() {
		System.out.println("nrStrings = " + nrStrings);
	}

}
