package employeehw;

public class Engineer extends Employee {

	public Engineer(int id, String name, String cnp, double salary) {
		super(id, name, cnp, salary);

	}

	@Override
	public String toString() {
		return "Engineer [ " + getId() + " , " + getName() + " , " + getCnp() + " , " + getSalary() + " ]";
	}

}
