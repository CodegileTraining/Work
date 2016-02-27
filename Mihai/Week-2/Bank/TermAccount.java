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
        Date date=new Date();
        dateFormat.format(date);
    }

    @Override
    public void withDraw(Double amount) {

    }

    @Override
    public String getDescription() {
        return getClass().toString();
    }
}
