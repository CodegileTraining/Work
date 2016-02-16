import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EmployeeCRUD {

	private ArrayList<Employee> crudList;

	public EmployeeCRUD() {

		this.crudList = new ArrayList<Employee>();
	}
	
	public ArrayList<Employee> getList(){
		return this.crudList;
	}

	public void create(Employee e){
		crudList.add(e);
	}

	public void read(String fileName){
		File file=new File(fileName);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				int id=sc.nextInt();
				String name=sc.next();
				String surname=sc.next();
				String ssn=sc.next();
				Employee e=new Employee(id, name, surname, ssn);
				this.crudList.add(e);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Employee> getCrudList() {
		return crudList;
	}

	public boolean update(int employeeID, Employee e){
		for(int i=0;i<this.crudList.size();i++){
			if(this.crudList.get(i).getId()==employeeID){
				if(e.getName().compareTo(this.crudList.get(i).getName())!=0){
					this.crudList.get(i).setName(e.getName());				
				}
				if(e.getSurrname().compareTo(this.crudList.get(i).getSurrname())!=0){
					this.crudList.get(i).setSurname(e.getSurrname());
				}
				return true;
			}	
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	public boolean delete(int id)
	{
		for(int i=0;i<crudList.size();i++)
		{
			if(crudList.get(i).getId()==id)
				crudList.remove(i);
			return true;
		}
		return false;
	}
}

