import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mihai on 26.02.2016.
 */
public class TermAccount extends Account {

    final DateFormat dateFormat;
    public TermAccount(Double amount){
        super(amount);
        dateFormat=new SimpleDateFormat("dd");
        Date dataAccount=new Date();
        dateFormat.format(dataAccount);
    }

    @Override
    public void withDraw(Double amount) {
        DateFormat currentDate=new SimpleDateFormat("dd");
        Date dataCurrenta=new Date();
        currentDate.format(dataCurrenta);
        if(currentDate!=dateFormat){
            balance=balance-amount;
        }
        else
            balance=balance+(balance*5/100)-amount;
    }
    public void deposit(Double amount){
        DateFormat currentDate=new SimpleDateFormat("dd");
        Date dataCurrenta=new Date();
        currentDate.format(dataCurrenta);
        if(currentDate!=dateFormat){
            balance=balance+amount;
        }
        else
            balance=balance+(balance*5/100)+amount;
    }

    @Override
    public String getDescription() {
        return getClass().toString();
    }
}