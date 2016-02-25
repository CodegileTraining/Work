package Day4;

import java.util.Comparator;

/**
 * This class implements a comparator by description
 * 
 * @author Margarit
 *
 */
public class DescriptioComparator implements Comparator<ShirtComp> {

	@Override
	public int compare(ShirtComp arg0, ShirtComp arg1) {
		return arg0.sh.getDescription().compareTo(arg1.sh.getDescription());
	}

}
