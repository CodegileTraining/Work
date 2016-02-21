package pack2;
/**
 * 		Class inherited from @Bonus, returns a type of @Bonus a @Employee can receive. 
 * @author Silviana
 *
 */
public class Coffee extends Bonus {

	public Coffee(int pieces, String data) {
		super(pieces, data);
		setDescription("Coffee");
	}
}