import java.util.Iterator;

public class Iterator2<T> implements Iterator<T> {

	private MyArrayList<T> list ;
	private int poz = 0;

	public Iterator2(MyArrayList<T> list) {
		this.list = list;

	}

	@Override
	public boolean hasNext() {

		return poz < list.size()-1;

	}

	@Override
	public T next() {
		
		T t = list.get(poz);
		poz = poz+2;
		return t;
	}

	@Override
	public void remove() {

	}
}