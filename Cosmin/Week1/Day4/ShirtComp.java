package Day4;

/**
 * This class is used to store a shirt and its occurrences in a structure.Also
 * used for CountComparator
 * 
 * @author Margarit
 *
 */
public class ShirtComp {

	Shirt sh;
	int count;

	public ShirtComp(Shirt sh, int count) {
		this.sh = sh;
		this.count = count;
	}

	@Override
	public String toString() {
		return "ShirtComp [sh=" + sh + ", count=" + count + "]";
	}

}
