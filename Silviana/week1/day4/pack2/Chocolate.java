package pack2;
/**
 * 		Class inherited from @Bonus, returns a type of @Bonus a @Employee can receive. 
 * @author Silviana
 *
 */
public class Chocolate extends Bonus {

	public Chocolate(int pieces, String data) {
		super(pieces, data);
		setDescription("Chocolate");
	}
}