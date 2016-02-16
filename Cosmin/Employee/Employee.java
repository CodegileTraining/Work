import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Employee {

	private int id;
	private String name;
	private String surrname;
	private String ssn;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurrname() {
		return surrname;
	}
	public void setSurname(String surname) {
		this.surrname = surname;
	}
	
	public int getId() {
		return id;
	}
	public String getSsn() {
		return ssn;
	}
	

	public int getAge(){


		StringBuilder sb=new StringBuilder();
		StringBuilder emplYear=new StringBuilder();
		sb.append(this.getSsn().charAt(1)).append(this.getSsn().charAt(2));
		
		int year=Calendar.getInstance().get(Calendar.YEAR);
		if(this.ssn.charAt(0)=='1' || this.ssn.charAt(1)=='2' )
			emplYear.append("19").append(sb);
		else
			emplYear.append("20").append(sb);
		
		System.out.println("Year:"+year+" EmplYear:"+emplYear);
		return year-Integer.parseInt(emplYear.toString());
	}

	public static  ArrayList<Employee> getEmployeeFromFile(String fileName){
		
		File file=new File(fileName);
		ArrayList<Employee> empl=new ArrayList<Employee>();
		try {
			Scanner sc = new Scanner(file);
			String line;
			while(sc.hasNextLine())
			{
				int id=sc.nextInt();
				String name=sc.next();
				String surname=sc.next();
				String ssn=sc.next();
				Employee e=new Employee(id, name, surname, ssn);
				empl.add(e);
			}

	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}

		return empl;
}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surrname=" + surrname + ", ssn=" + ssn + "]";
	}
	public Employee(int id, String name, String surrname, String ssn) {
		super();
		this.id = id;
		this.name = name;
		this.surrname = surrname;
		this.ssn = ssn;
	}


}
