
public class Employee {

	private int id;
	private String name;
	private String surname;
	private String ssn;

	public Employee(int id, String name, String surname, String ssn) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getSsn() {
		return ssn;
	}

	public int getYear(String ssn) {
		int year;
		int x1 = ssn.charAt(1);
		int x2 = ssn.charAt(2);
		year = x1 * 10 + x2;
		return year;
	}

	public int getVarsta() {
		int year;

		year = 1 * 1000 + 9 * 100 + ssn.charAt(1) * 10 + ssn.charAt(2);

		return 2016 - year;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", ssn=" + ssn + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}
