import java.util.ArrayList;
import java.util.Iterator;

public class Iterator2in2<T> implements Iterator<T> {

	private int index = 0;
	private ArrayList<T> list;

	public Iterator2in2(ArrayList<T> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index < list.size();
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		T e = list.get(index);
		index += 2;
		return e;

	}

}
