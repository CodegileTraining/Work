import java.util.Comparator;

public class ComparatorS implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.Age()-o2.Age();
	}

	
}
