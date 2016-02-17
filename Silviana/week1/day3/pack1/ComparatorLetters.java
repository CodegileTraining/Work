package pack1;

import java.util.Comparator;

public class ComparatorLetters implements Comparator<Product> {

	@Override
	public int compare(Product ob1, Product ob2) {
		return ob1.getDescription().compareTo(ob2.getDescription());
	}


		}

	

