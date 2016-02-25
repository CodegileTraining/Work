package Day3;

import java.util.Comparator;

public class ProdComp implements Comparator<ProdComp>,Comparable<ProdComp>{

	Produs p;
	int count;
	
	public ProdComp(Produs p, int count) {
		this.p = p;
		this.count = count;
	}
	public ProdComp() {
	}
	@Override
	public int compareTo(ProdComp o) {
		return p.compareTo(o.p);
	}
	@Override
	public int compare(ProdComp o1, ProdComp o2) {
		return o1.p.compareTo(o2.p);
	}
	@Override
	public String toString() {
		return "ProdComp [p=" + p + ", count=" + count + "]";
	}

	

	

}
