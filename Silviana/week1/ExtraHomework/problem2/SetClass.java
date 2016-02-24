package problem2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetClass<K> implements Set<K> {
	 
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
		Iterator<K> it=list.iterator();
		while(it.hasNext())
			if(it.next().equals(o))
				return true;
		return false;
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
		if(list.contains(c))
			return true;
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends K> c) {
		return list.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}

	@Override
	public void clear() {
		list.clear();

	}

}
