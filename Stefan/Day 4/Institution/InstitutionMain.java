import java.io.FileNotFoundException;
/**
 * Main
 * @author Stefan
 *
 */
public class InstitutionMain {

	
	

	private static Institution inst;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		

		inst = Institution.getInstance();
		
		inst.printEmployes();
		inst.printAttentions();
		inst.maxAtnPerMonth("martie");

		
	}

	
	
	
}
