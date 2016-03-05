import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mihai on 26.02.2016.
 */
public class CurrentAccount extends Account {

    final DateFormat dateFormat;
    public CurrentAccount(Double amount) {
        super(amount);
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        dateFormat.format(date);
    }

    @Override
    public String getDescription() {
        return getClass().toString();
    }

    public void withDraw(Double amount) throws MyExceptions {
        try {
            if (balance - amount < balance * (10 / 100))
                throw new NotEnoughMoney();
            balance=balance-amount;
        }catch (NotEnoughMoney e){

        }

    }
}
