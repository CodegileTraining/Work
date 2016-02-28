package problem2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueClass<K> implements Queue<K> {

	
	private Queue<K> queue = new LinkedList<>();

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
		return queue.contains(o);
	}

	@Override
	public Iterator<K> iterator() {
		return queue.iterator();
	}

	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <K> K[] toArray(K[] a) {
		return queue.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return queue.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return queue.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends K> c) {
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
	public boolean add(K e) {
		if(queue.contains(e))
			return false;
		queue.add(e);
		return true;
	}

	@Override
	public boolean offer(K e) {
		return queue.offer(e);
	}

	@Override
	public K remove() {
		return queue.remove();
	}

	@Override
	public K poll() {
		return queue.poll();
	}

	@Override
	public K element() {
		return queue.element();
	}

	@Override
	public K peek() {
		return queue.peek();
	}

}
