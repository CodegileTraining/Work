/**
 * Created by Mihai on 26.02.2016.
 */
public class MyExceptions extends Exception {
}
class NotEnoughMoney extends MyExceptions{
    public NotEnoughMoney(){
        System.out.print("Not Enough Money for WithDrawl!");
    }

}
