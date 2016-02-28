package employeehw;

public class Admin extends Employee {

	public Admin(int id, String name, String cnp, double salary) {
		super(id, name, cnp, salary);

	}

	@Override
	public String toString() {
		return "Admin [" + getId() + " , " + getName() + " , " + getCnp() + " , " + getSalary() + "]";
	}

}
