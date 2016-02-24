package problem2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListClass<K> implements List<K> {

	private List<K> list = new ArrayList<>();
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		if(list.isEmpty())
			return true;
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public Iterator<K> iterator() {
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <K> K[] toArray(K[] a) {
		return list.toArray(a);
	}

	@Override
	public boolean add(K e) {
		if(list.contains(e))
			return false;
		list.add(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if(!list.contains(o))
			return false;
		list.remove(o);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends K> c) {
		return list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends K> c) {
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
	public K get(int index) {
		return list.get(index);
	}

	@Override
	public K set(int index, K element) {
		return list.set(index, element);
	}

	@Override
	public void add(int index, K element) {
		list.add(index, element);
		
	}

	@Override
	public K remove(int index) {
		return list.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).equals(o))
				return i;
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		return list.lastIndexOf(o);
	}

	@Override
	public ListIterator<K> listIterator() {
		return list.listIterator();
	}

	@Override
	public ListIterator<K> listIterator(int index) {
		return list.listIterator(index);
	}

	@Override
	public List<K> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}


}
