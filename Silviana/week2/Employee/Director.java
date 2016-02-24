package employeehw;

public class Director extends Manager {

	private double budget;

	public Director(int id, String name, String cnp, double salary, String depName, double budget) {
		super(id, name, cnp, salary, depName);
		this.budget = budget;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Director [ " + getId() + " , " + getName() + " , " + getCnp() + " , " + getSalary() + " , "
				+ getDepName() + " , " + budget + " ]";

	}

}
