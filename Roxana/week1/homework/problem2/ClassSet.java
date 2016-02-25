package pack1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ClassSet<T> implements Set<T> {

	private ArrayList<T> set = new ArrayList<T>();

	@Override
	public int size() {

		return set.size();
	}

	@Override
	public boolean isEmpty() {
		if (set.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public boolean contains(Object o) {
		if (set.contains(o))
			return true;
		else
			return false;
	}

	@Override
	public Iterator<T> iterator() {

		return set.iterator();
	}

	@Override
	public Object[] toArray() {

		return set.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {

		return set.toArray(a);
	}

	@Override
	public boolean add(T e) {
		if (set.contains(e))
			return false;
		else
			set.add(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if(!set.contains(o))
		return false;
		else
			set.remove(o);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		return set.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		
		return set.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		return set.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		return set.removeAll(c);
	}

	@Override
	public void clear() {
		set.clear();
	}

}
