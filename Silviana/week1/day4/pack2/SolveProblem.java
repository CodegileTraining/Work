package pack2;

import java.util.ArrayList;
import java.util.HashMap;

public class SolveProblem {
/**
 * 		Creates a single instance of the @Institution class. This thing is called Singleton.
 * @param args
 * 		The arguments which will be introduced in the console.
 */
	public static void main(String[] args) {
		Institution inst = Institution.getInstance();
		inst.readEmployees();
		inst.addBonusForEmployees();
		//inst.printEmployees();
		HashMap<Integer, ArrayList<Bonus>> monthlyBonuses = new HashMap<>();
		monthlyBonuses=inst.getMonthlyReport(2016);
		inst.printMonthlyReport(2016, monthlyBonuses);
	    inst.getEmployeeWithMostBonuses(2016, monthlyBonuses);
	}
}
