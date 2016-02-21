package pack2;

/**
 * 		Class inherited from @Bonus, returns a type of @Bonus a @Employee can receive. 
 * @author Silviana
 *
 */
public class ExtraMoney extends Bonus {

	public ExtraMoney(int pieces, String data) {
		super(pieces, data);
		setDescription("ExtraMoney");
	}
}
