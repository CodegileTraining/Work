package problem3;

public class Orchestra {

	public static void main(String[] args) {
		Instrument[] orchestra = { new Brass(), new Percussion(), new Stringed(), new Wind(), new WoodWind() };
		for(Instrument i : orchestra)
			   i.play("SOL");
	}

}
