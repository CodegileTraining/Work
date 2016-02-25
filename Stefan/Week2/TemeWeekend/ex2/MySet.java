package Fisier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MySet<T> implements Set<T>{

	List<T> list=new ArrayList<T>();
	
	@Override
	public boolean add(T e) {
		if (!list.contains(e)){
			list.add(e);
			return true;	
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		if (list.containsAll(c))
		return false;
		else
			list.addAll(c);
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.removeAll(list);
	}

	@Override
	public boolean contains(Object o) {
		if (list.contains(o))
		return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (list.containsAll(c))
		return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (list.isEmpty())
		return true;
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

	@Override
	public boolean remove(Object o) {
		if (list.remove(o))
		return true;
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (list.removeAll(c))
		return true;
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		
		return list.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
