/**
 * Class Employee (Employee structure)
 * Contains ID,Name,Surname,SSN,type 
 * @author Stefan
 *
 */
public class Employee {

	private int ID;
	private String Name;
	private String Surname;
	private String SSN;
	private String type;

	public Employee(int iD, String name, String surname, String sSN, String tip) {

		ID = iD;
		Name = name;
		Surname = surname;
		SSN = sSN;
		type = tip;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", Name=" + Name + ", Surname=" + Surname + ", SSN=" + SSN + ", type=" + type
				+ "]";
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}

	public String getSurname() {
		return Surname;
	}

	public String getSSN() {
		return SSN;
	}

	public String getType() {
		return type;
	}

}
