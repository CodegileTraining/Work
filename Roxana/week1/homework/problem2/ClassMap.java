package pack1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClassMap<K, T> implements Map<K, T> {

	Map<K, T> map = new HashMap<K, T>();

	@Override
	public int size() {

		return map.size();
	}

	@Override
	public boolean isEmpty() {

		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		if (map.containsKey(key))
			return true;
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		if (map.containsValue(value))
			return true;
		return false;
	}

	@Override
	public T get(Object key) {

		return map.get(key);
	}

	@Override
	public T put(K key, T value) {

		return map.put(key, value);
	}

	@Override
	public T remove(Object key) {

		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends T> m) {
		map.putAll(m);

	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set<K> keySet() {

		return map.keySet();
	}

	@Override
	public Collection<T> values() {

		return map.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, T>> entrySet() {

		return map.entrySet();
	}

}
