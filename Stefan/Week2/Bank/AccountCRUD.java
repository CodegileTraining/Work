import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class AccountCRUD implements CRUDAccountInterface {

	List<Account> accList = new ArrayList<Account>();

	public void create(Account a) {
		if (a != null)
			accList.add(a);
	}

	public void delete(int index) {
		accList.remove(index);
	}

	@Override
	public Account read(Scanner input) throws ParseException {
		String[] words = input.nextLine().split(",");
		Account a = null;
		switch (Integer.parseInt(words[0])){ 
		case 1: {
			DateFormat df = new SimpleDateFormat("dd MM yyyy");
			Date createDate = df.parse(words[3]);
			Calendar calCreate = new GregorianCalendar();
			calCreate.setTime(createDate);

			Date termenDate = df.parse(words[4]);
			Calendar calTermen = new GregorianCalendar();
			calTermen.setTime(termenDate);
			a = new DepositAccount(Integer.parseInt(words[1]), Integer.parseInt(words[2]),
					(GregorianCalendar) calCreate, (GregorianCalendar) calTermen);
			break;
		}
		case 2: {
			DateFormat df = new SimpleDateFormat("dd MM yyyy");
			Date createDate = df.parse(words[3]);
			Calendar calCreate = new GregorianCalendar();
			calCreate.setTime(createDate);

			a = new NormalAccount(Integer.parseInt(words[1]), Integer.parseInt(words[2]), (GregorianCalendar) calCreate,
					Integer.parseInt(words[4]));
			break;
		}
		}

		return a;
	}

	@Override
	public void update(Account a, int balance) {
		// TODO Auto-generated method stub

	}
}
