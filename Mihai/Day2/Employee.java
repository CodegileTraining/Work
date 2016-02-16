import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Employee {

	int ID;
	long SSN;
	String name;
	String surname;

	public Employee(int id, long SSN, String name, String surname) {
		this.ID = id;
		this.SSN = SSN;
		this.name = name;
		this.surname = surname;
	}

	public long getSSN() {
		return SSN;
	}
	public void setID(int id){
		this.ID=id;
	}
	public void setSSN(long ssn){
		this.SSN=ssn;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setSurnname(String s){
		this.surname=s;
	}
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			Employee s = (Employee) o;
			if (this.SSN == s.getSSN())
				return true;
			return false;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public String getSurnName() {
		return surname;
	}

	public int getID() {
		return ID;
	}

	public String toString() {
		return ID + ":" + name + " " + surname;
	}

	public static void getThoseWithNonInspiratedParents(ArrayList<Employee> o) {
		for (int i = 0; i < o.size(); i++) {
			if (o.get(i).getName().equals(o.get(i).getSurnName()))
				System.out.println(o.get(i));
		}
	}
}
