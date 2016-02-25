package Fisier;

import java.util.Comparator;

public class ComparatorCase implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		
		return arg0.compareToIgnoreCase(arg1);
	}

}
