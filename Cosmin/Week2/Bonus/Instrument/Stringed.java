package Week2.Instrument;

public class Stringed implements Instrument{

	@Override
	public void play() {
		System.out.println("Stringed.Play");
		
	}

	@Override
	public String what() {
		
		return "Stringed.what";
	}

	@Override
	public void adjust() {
		System.out.println("Stringed.adjust");
		
	}

}
