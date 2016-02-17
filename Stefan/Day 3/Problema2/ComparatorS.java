import java.util.Comparator;

public class ComparatorS implements Comparator<Produs>{

	@Override
	public int compare(Produs arg0, Produs arg1) {
		// TODO Auto-generated method stub
		//if (arg0.getDescriere().compareTo(arg1.getDescriere())>0) return 0;
		//return 1;
		return arg0.getDescriere().compareTo(arg1.getDescriere());
	}

}
