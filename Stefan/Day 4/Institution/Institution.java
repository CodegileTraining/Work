import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 * Singleton Institution
 * Contains the employee-type list, an EmployeeCRUD object, list of attentions
 * @author Stefan
 *
 */
public class Institution {

	private String[] emplTypeList = { "CEO", "Manager", "Programmer", "Secretary" };
	private static String[] months = { "ianuarie", "februarie", "martie", "aprilie", "mai", "iunie", "iulie",
			"august" };
	private EmployeeCRUD empl;
	private List<Attention> atnList;
	private static HashMap<Integer, Employee> mapEmployes = new HashMap<Integer, Employee>();

	private static Institution instance;
	private static Scanner input;

	private Institution() {
		try {
			setEmpl(readEmployes(emplTypeList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			setAtnList(readAttentions());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * return the instance of Institution
 * @return
 */
	public static Institution getInstance() {
		if (instance == null) {
			instance = new Institution();
		}
		return instance;
	}
/**
 * Read the employes from file
 * @param emplTypeList
 * @return
 * Return an EmployeeCRUD object
 * @throws FileNotFoundException
 */
	public static EmployeeCRUD readEmployes(String[] emplTypeList) throws FileNotFoundException {

		input = new Scanner(System.in);
		File file = new File("angajati.txt");
		input = new Scanner(file);

		EmployeeCRUD a = new EmployeeCRUD();
		while (input.hasNextLine()) {

			Employee e = a.read(input, emplTypeList);
			a.create(e);
			mapEmployes.put(e.getID(), e);
		}
		input.close();
		return a;
	}
/**
 * Read attentions from file
 * @return
 * Returns list of attentions
 * @throws FileNotFoundException
 */
	public static List<Attention> readAttentions() throws FileNotFoundException {

		List<Attention> list = new ArrayList<Attention>();

		input = new Scanner(System.in);
		File file = new File("atentii.txt");
		input = new Scanner(file);

		while (input.hasNextLine()) {

			String[] words = input.nextLine().split(",");
			if (verifyMonthId(words)) {
				Attention a = new Attention(Integer.parseInt(words[0]), Integer.parseInt(words[1]), words[2]);
				list.add(a);
			}
		}

		input.close();
		return list;
	}
/**
 * Print all employes
 */
	public void printEmployes() {
		System.out.println("Employes List: ");
		for (Employee e : empl.employeeList)
			System.out.println(e);
		System.out.println();
		System.out.println();

	}
/** 
 * print attentions
 */
	public void printAttentions() {
		System.out.println("Attention List: ");
		for (Attention e : atnList)
			System.out.println(e);
		System.out.println();
		System.out.println();
	}
/**
 * Print the employe-type with the largest attention value from a given month
 * @param month
 */
	public void maxAtnPerMonth(String month) {

		HashMap<String, Integer> atnMap = new HashMap<String, Integer>();
		
		for (int i=0;i<emplTypeList.length;i++)
			atnMap.put(emplTypeList[i], 0);
		
		for (Attention a:atnList){
			if (a.getMonth().equals(month)){
				Employee e=mapEmployes.get(a.getIDemployee());
				int aux=atnMap.get(e.getType())+a.getValue();
				atnMap.remove(e.getType());
				atnMap.put(e.getType(), aux);
			}
				
		}
		int maxValueInMap=(Collections.max(atnMap.values()));
		
		for (Entry<String, Integer> entry : atnMap.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                System.out.println(entry.getKey()+"    "+ maxValueInMap);     // Print the key with max value
            }
        }
	}
/**
 * Verify valid attention
 * @param words
 * @return
 */
	public static boolean verifyMonthId(String[] words) {

		boolean flag = false;
		for (int i = 0; i < months.length; i++)
			if (words[2].equals(months[i]))
				flag = true;
		if (!flag)
			return false;

		if (!mapEmployes.containsKey(Integer.parseInt(words[1])))
			return false;

		return true;
	}

	public EmployeeCRUD getEmpl() {
		return empl;
	}

	public void setEmpl(EmployeeCRUD empl) {
		this.empl = empl;
	}

	public List<Attention> getAtnList() {
		return atnList;
	}

	public void setAtnList(List<Attention> atnList) {
		this.atnList = atnList;
	}
}
