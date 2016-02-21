import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Iterator<T> Iterator2in2() {
		return new Iterator2in2<>(this);
	}
	
	private static void print(Iterator<?> iterator) {
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	private Iterator<T> IteratorPrimUltim(){
		return new IteratorPrimUltim<>(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyArrayList<Integer> myList = new MyArrayList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);

		Iterator<Integer> it = myList.Iterator2in2();

		print(it);
		
		it = myList.IteratorPrimUltim();
		print(it);
	}

}
