package Day4;

import java.util.Comparator;

/**
 * This class implements a comparator by count
 * 
 * @author Margarit
 *
 */
public class CountComparator implements Comparator<ShirtComp> {

	@Override
	public int compare(ShirtComp arg0, ShirtComp arg1) {
		return arg0.count - arg1.count;
	}

}
