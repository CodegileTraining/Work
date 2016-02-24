package problem2;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapClass<K, V> implements Map<K, V> {

	Map<K, List<V>> map = new HashMap<K, List<V>>();

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		if (!map.isEmpty())
			return false;
		return true;
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		return (V) map.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {
		return (V) map.remove(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		map.putAll((Map<? extends K, ? extends List<V>>) m);

	}

	@Override
	public void clear() {
		map.clear();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Set keySet() {
		return map.keySet();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection values() {
		return map.values();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Set entrySet() {
		return map.entrySet();
	}

	@SuppressWarnings("unchecked")
	@Override
	public V put(K key, V value) {
		return (V) map.put(key, (List<V>) value);
		
	}

}
