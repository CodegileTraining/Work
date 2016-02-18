import java.util.Comparator;

public class ComparatorD implements Comparator <Tricou> {

	@Override
	public int compare(Tricou o1, Tricou o2) {
		return o1.getDescriere().compareTo(o2.getDescriere());
	}

}
