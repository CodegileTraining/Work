package Week2.Instrument;

public class InstrumentMain {

	public static void main(String[] s) {

		Instrument instr=new Wind();
		
		System.out.println(instr.what());
		instr.play();
		instr.adjust();
		
		instr=new Percussion();
		System.out.println("\n"+instr.what());
		instr.play();
		instr.adjust();
		
		instr=new Stringed();
		System.out.println("\n"+instr.what());
		instr.play();
		instr.adjust();
		
		instr=new WoodWind();
		System.out.println("\n"+instr.what());
		instr.play();
		instr.adjust();
		
		instr=new Brass();
		System.out.println("\n"+instr.what());
		instr.play();
		instr.adjust();
	}
}
