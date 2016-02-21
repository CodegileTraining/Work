package pack2;
/**
 * 		Contains all informations for the employees of the @Institution.
 * @author Silviana
 *
 */
import java.util.ArrayList;

public class Employee {
	private String fullname;
	private ArrayList<Bonus> bonuses = new ArrayList<Bonus>();

	public Employee(String fullname) {
		super();
		this.fullname = fullname;
	}

	public Employee() {
	}

	public String getFullname() {
		return fullname;
	}

	public ArrayList<Bonus> getBonuses() {
		return bonuses;
	}

	public void addBonus(Bonus b) {
		bonuses.add(b);
	}

	public void getNrBonuses() {
		bonuses.size();
	}

	@Override
	public String toString() {
		return "Employee [fullname=" + fullname + ", bonuses=" + bonuses + "]";
	}

}
