package ThinkingInJava.ContainersInDepth.P632;
import java.util.*;

public class SlowMap2<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    HashSet<String> hs;
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }

    public V get(Object key) {
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }
    class EntrySet extends AbstractSet<Map.Entry<K,V>>{
        private int size;
        public EntrySet() { size = keys.size(); }

        private class Iter implements Iterator<Map.Entry<K,V>>{
            private int counter = -1;
            @Override
            public boolean hasNext() {
                boolean ind = counter < size - 1;
                if (!ind) counter = -1;
                return ind;
            }
            @Override
            public MapEntry<K,V> next() {
                counter++;
                return new MapEntry<>(keys.get(counter), values.get(counter));
            }
            @Override
            public void remove() {
                int cursor = size - 1;
                keys.remove(cursor);
                values.remove(cursor);
                size--;
                counter--;
            }
        }
        @Override
        public int size() { return size; }
        public Iterator<Map.Entry<K,V>> iterator(){ return new Iter(); }
    }
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }
}