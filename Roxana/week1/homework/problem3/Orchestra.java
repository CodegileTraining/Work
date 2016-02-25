
public class Orchestra {

	public static void main(String[] args) {
		String desc;
		Instrument[] orchestra = { new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind() };
		for(Instrument i:orchestra)
			{
			 i.play();
			 i.adjust();
			
			 System.out.print(i.what());
			
			}
			
	}

}
