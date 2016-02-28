package Fisier;

public class ImbricatedClasses {

	private int test=9;
	
	public class ClasaImbricata{
		private int numar=2;
		
		public ClasaImbricata(){
			System.out.println("clasa mica");
			test=3;
		}
	}
	
	public ImbricatedClasses(){
		System.out.println("clasa mare");
		//numar=4;//eroare de acces
	}
	
}
