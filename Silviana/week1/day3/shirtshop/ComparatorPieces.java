package shirtshop;

import java.util.Comparator;

public class ComparatorPieces implements Comparator<Shirt> {

	public int compare(Shirt arg0, Shirt arg1) {
		return arg0.getNrpieces() - arg1.getNrpieces();

	}
}
