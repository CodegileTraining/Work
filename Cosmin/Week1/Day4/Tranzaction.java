package Day4;

/**
 * This class defines and implements the transactions allowed over a shirt.
 * 
 * @author Margarit
 *
 */
public class Tranzaction {

	public void buy(ShirtStorage shirtMap, int id, int quantity) {
		try {
			shirtMap.put(shirtMap.shirtExists(id), quantity);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

	public void sell(ShirtStorage shirtMap, int id, int quantity) {
		try {
			shirtMap.remove(shirtMap.shirtExists(id), quantity);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

}
