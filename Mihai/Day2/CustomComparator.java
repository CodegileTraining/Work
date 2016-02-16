import java.util.Comparator;

public class CustomComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		long n1,n2;
		n1=o1.getSSN()/1000000;
		n2=o2.getSSN()/1000000;
		n1=n1%1000000;
		n2=n2%1000000;
		if(n1<n2)
			return -1;
		if(n2<n1)
			return 1;
		return 0;
	}

}
