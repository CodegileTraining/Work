package SingletonInstitution;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Institution class is a singleton class that stores a list of bonuses.
 */
public class Institution {

	private static Institution instance = null;
	List<Bonus> bonusList = null;

	private Institution() {

	}

	/**
	 * This method is used to instantiate the singleton class only once.
	 * 
	 * @return The object of type Institution.
	 */
	public static Institution getInstance() {

		if (instance == null) {
			instance = new Institution();
		}
		return instance;
	}

	/**
	 * This method adds a bonus to the list of bonuses.
	 * 
	 * @param b
	 *            Represents the bonus that needs to be added to the list.
	 */
	public void giveBonus(Bonus b) {
		if (bonusList == null)
			bonusList = new ArrayList<>();
		bonusList.add(b);
	}

	@Override
	public String toString() {
		if (bonusList == null)
			return null;
		StringBuilder sb = new StringBuilder();
		for (Bonus b : bonusList) {
			sb.append(b.toString()).append("\n");
		}
		return sb.toString();
	}

	/**
	 * This method creates a HashMap which stores all bonuses for every month in
	 * the specified year
	 * 
	 * @param year
	 *            Specifies the year for the report
	 */
	public void bonusesByMonth(int year) {

		HashMap<Integer, ArrayList<Bonus>> bonMap = new HashMap<>();
		for (Bonus b : bonusList) {
			Calendar c = b.getDate();
			if (c.get(Calendar.YEAR) == year) {
				ArrayList<Bonus> monthBonuses = bonMap.get(c.get(Calendar.MONTH));
				if (monthBonuses != null) {
					monthBonuses.add(b);
					bonMap.put(c.get(Calendar.MONTH), monthBonuses);
				} else {
					monthBonuses = new ArrayList<Bonus>();
					monthBonuses.add(b);
					bonMap.put(c.get(Calendar.MONTH), monthBonuses);
				}
			}
		}

		for (int i = Calendar.JANUARY; i < Calendar.DECEMBER; i++) {
			ArrayList<Bonus> bonList = bonMap.get(i);
			if (bonList != null) {
				System.out.println("Bonuses for month " + (i + 1) + ":");
				for (Bonus b : bonList) {
					System.out.println(b);
				}
				System.out.println();
			}
		}
	}

}
