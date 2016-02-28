package pack1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ClassList<T> implements List<T> {

	ArrayList<T> list = new ArrayList<>();

	@Override
	public int size() {
		return list.size();

	}

	@Override
	public boolean isEmpty() {
		if (list.isEmpty())
			return true;
		return false;
	}

	@Override
	public boolean contains(Object o) {
		if (list.contains(o))
			return true;
		return false;
	}

	@Override
	public Iterator<T> iterator() {

		return list.iterator();
	}

	@Override
	public Object[] toArray() {

		return list.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {

		return list.toArray(a);
	}

	@Override
	public boolean add(T e) {

		return list.add(e);
		
	}

	@Override
	public boolean remove(Object o) {

		if (!list.contains(o))
			return false;
		else
			list.remove(o);
		return true;

	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {

		return list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {

		return list.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		return list.retainAll(c);
	}

	@Override
	public void clear() {
		list.clear();

	}

	@Override
	public T get(int index) {

		return list.get(index);
	}

	@Override
	public T set(int index, T element) {

		return list.set(index, element);
	}

	@Override
	public void add(int index, T element) {

		list.add(index, element);

	}

	@Override
	public T remove(int index) {

		return list.remove(index);
	}

	@Override
	public int indexOf(Object o) {

		return list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {

		return list.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {

		return list.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {

		return list.listIterator(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {

		return list.subList(fromIndex, toIndex);
	}

}
