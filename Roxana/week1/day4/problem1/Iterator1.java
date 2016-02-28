import java.util.Iterator;

public class Iterator1<T> implements Iterator<T> {

	private MyArrayList<T> list ;
	private int poz = 0;

	public Iterator1(MyArrayList<T> list) {
		this.list = list;

	}

	@Override
	public boolean hasNext() {

		return poz < list.size();

	}

	@Override
	public T next() {
		return  list.get(poz++);
	}

	@Override
	public void remove() {

	}
}
