import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<T> extends ArrayList<T> {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		MyArrayList<Integer> list = new MyArrayList<Integer>();
		Iterator1<Integer> it = new Iterator1<Integer>(list);
		list.add(1);
		list.add(2);
		list.add(34);
		list.add(5);

		System.out.println("Normal Iterator: ");
		while (it.hasNext()) {

			System.out.print(it.next() + " ");

		}
		System.out.println();
		Iterator2<Integer> it2 = new Iterator2<Integer>(list);

		System.out.println("Two by two Iterator");
		while (it2.hasNext()) {
			System.out.print(it2.next() + " ");

		}
		System.out.println();
		
		Iterator3<Integer> it3 = new Iterator3<Integer>(list);
		
		System.out.println("First Last Iterator");
		while(it3.hasNext()){
			System.out.println(it3.next());
		}
	}
}