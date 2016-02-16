import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Employee {

	private int ID;
	private String Name;
	private String Surname;
	private String SSN;
	private static EmployeeCRUD a;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		a = openFile();
		
		for(int i=0;i<a.employeeList.size();i++)
			if (a.employeeList.get(i).after80() && a.employeeList.get(i).sameNameSurname())
			System.out.println(a.employeeList.get(i));
		
		a.employeeList.sort(new ComparatorS());
		
		for(int i=0;i<a.employeeList.size();i++)
			System.out.println(a.employeeList.get(i));
	}

	public int Age(){
		char x=SSN.charAt(1);
		char y=SSN.charAt(2);
		StringBuilder s = new StringBuilder("00");
		s.setCharAt(0, x);
		s.setCharAt(1, y);
		int aux=Integer.parseInt(s.toString());
		if (SSN.charAt(0)>='5') return 16-aux;
		else return 100-aux+16;
	}
	
	public boolean sameNameSurname(){
		if (Name.equals(Surname)) return true;
		else return false;
	}
	
	public boolean after80(){
		char x=SSN.charAt(1);
		char y=SSN.charAt(0);
		if (y=='5' || y=='6' ) return true;
		if(x>='8') return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", Name=" + Name + ", Surname=" + Surname + ", SSN=" + SSN + "]";
	}

	public void setAll(String w1,String w2,String w3,String w4){
		ID=Integer.parseInt(w1);
		Name=w2;
		Surname=w3;
		SSN=w4;
	}
	
	public static EmployeeCRUD  openFile() throws FileNotFoundException
	{
		EmployeeCRUD a=new EmployeeCRUD();
		Scanner input = new Scanner(System.in);
		File file = new File("Employes.txt");
		input = new Scanner(file);
		
		while (input.hasNextLine()){
			
			
			Employee object=a.read(input);
			a.create(object);
		}
		input.close();
		return a;
	}
}
