package SingletonInstitution;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;

/**
 * Bonus class is used to store the bonus type,the date and the employee who received the bonus.
 */
public class Bonus {
	

	private eBonus bonus;
	private Calendar date = Calendar.getInstance();
	private Employee empl;

	public Bonus(eBonus bonus, String date, Employee empl) {
		this.bonus = bonus;
		this.empl = empl;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = formatter.parse(date);
			this.date.setTime(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public eBonus getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return "Bonus [bonus=" + bonus + ", date=" + format.format(date.getTime()) + ", empl=" + empl + "]";
	}

	public void setBonus(eBonus bonus) {
		this.bonus = bonus;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Employee getEmpl() {
		return empl;
	}

	public void setEmpl(Employee empl) {
		this.empl = empl;
	}

}
