import java.util.Comparator;
/**
 * 
 * @author Stefan
 *Compares shirts using the  current sold 
 */
public class ComparatorA implements Comparator<Shirt> {

	@Override
	public int compare(Shirt arg0, Shirt arg1) {
		// TODO Auto-generated method stub
		return arg0.getNrBucati()-arg1.getNrBucati();
	}

}
