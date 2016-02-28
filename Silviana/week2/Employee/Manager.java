package employeehw;

public class Manager extends Employee {

	private String depName;

	public Manager(int id, String name, String cnp, double salary, String depName) {
		super(id, name, cnp, salary);
		this.depName = depName;

	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Override
	public String toString() {
		return "Manager [ " + getId() + " , " + getName() + " , " + getCnp() + " , " + getSalary() + " , " + depName
				+ " ]";
	}

}
