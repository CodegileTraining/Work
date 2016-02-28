package pack1;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ClassQueue<T> implements Queue<T> {

	private Queue<T> queue = new LinkedList<T>();

	@Override
	public int size() {

		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		if (queue.isEmpty())
			return true;
		return false;
	}

	@Override
	public boolean contains(Object o) {
		if (queue.contains(o))
			return true;
		return false;
	}

	@Override
	public Iterator<T> iterator() {

		return queue.iterator();
	}

	@Override
	public Object[] toArray() {

		return queue.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {

		return queue.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		if (!queue.contains(o))
			return false;
		else
			queue.remove(o);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return queue.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {

		return queue.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return queue.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		return queue.retainAll(c);
	}

	@Override
	public void clear() {
		queue.clear();

	}

	@Override
	public boolean add(T e) {
		if (queue.contains(e))
			return false;
		else
			queue.add(e);
		return true;
	}

	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
