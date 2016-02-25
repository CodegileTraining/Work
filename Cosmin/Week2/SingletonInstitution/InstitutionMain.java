package SingletonInstitution;

import java.util.ArrayList;
import java.util.List;  

/**
 * This class contains the main function which creates an array of employees and
 * instantiate the singleton class.
 * 
 * @author Margarit
 *
 */
public class InstitutionMain {

	/**
	 * This is the main method which creates a employee list,instantiate the
	 * singleton class and prints the bonuses accorded each month.
	 */
	public static void main(String[] args) {

		List<Employee> emplList = new ArrayList<>();
		emplList.add(new Employee("Cosmin"));
		emplList.add(new Employee("Paul"));
		emplList.add(new Employee("Mihai"));
		emplList.add(new Employee("Stefan"));
		Institution instance = Institution.getInstance();

		instance.giveBonus(new Bonus(eBonus.Chocolate, "21/2/2016", emplList.get(0)));
		instance.giveBonus(new Bonus(eBonus.Chocolate, "21/3/2016", emplList.get(0)));
		instance.giveBonus(new Bonus(eBonus.Coffee, "2/4/2016", emplList.get(2)));
		instance.giveBonus(new Bonus(eBonus.ShopingCard, "2/5/2016", emplList.get(1)));
		instance.giveBonus(new Bonus(eBonus.GiftBasket, "24/5/2016", emplList.get(3)));
		instance.giveBonus(new Bonus(eBonus.GiftBasket, "24/5/2015", emplList.get(3)));

		instance.bonusesByMonth(2016);

	}

}
