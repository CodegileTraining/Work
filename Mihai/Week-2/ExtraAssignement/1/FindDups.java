import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Mihai on 23.02.2016.
 */
public class FindDups {

    public static void main(String[] args) {


        SortedSet<String> s = new TreeSet<>(new MyComparator());
        for (String a : args) {
            if (!s.add(a))
                System.out.println("Duplicate detected " + a);

            System.out.println(s.size() + " distinct words: " + s);

        }


    }


}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.toLowerCase().compareTo(o2.toLowerCase());
    }
}
