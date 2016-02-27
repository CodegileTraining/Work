import java.util.Date;

/**
 * Created by Mihai on 25.02.2016.
 */
//We get error when we try to overload the methods in interface
public class Class1 implements Interface1 {
    @Override
    public
    Date getDate() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }


    public int getSomethign(String x) {
        return 0;
    }
    public static void main(String[] args){
        c=2;  ///c cannot be modified because is final and we can call here for hmim because is static
    }
}
