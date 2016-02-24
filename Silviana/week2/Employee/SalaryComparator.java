package employeehw;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

	public int compare(Employee arg0, Employee arg1) {
		if (arg0 instanceof Manager && arg1 instanceof Manager)
			return (int) (arg0.getSalary() - arg1.getSalary());
		return 0;

	}

}