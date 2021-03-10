package ThinkingInJava.ContainersInDepth.P632;
import java.util.*;
//--------------Part1-------------------------------
//Exercise 36: (5) Modify SlowMap so that instead of
// two ArrayLists, it holds a single ArrayList of
// MapEntry objects. Verify that the modified version
// works correctly. Using MapPerformance.java, test
// the speed of your new Map. Now change the put( )
// method so that it performs a sort( ) after each
// pair is entered, and modify get( ) to use
// Collections.binarySearch( ) to look up the key.
// Compare the performance of the new version with the old ones.

public class SlowMap3<K,V> extends AbstractMap<K,V> {
    //private List<K> keys = new ArrayList<>();
    //private List<V> values = new ArrayList<>();
    private List<Map.Entry<K,V>> entries = new ArrayList<>();
    HashMap<String,Integer> hs;
    public V put(K key, V value) {
        V oldValue = get(key);
        Map.Entry<K,V> entry = new MapEntry<>(key, value);
        if (!keySet().contains(key))
            entries.add(entry);
        else
            entries.set(entries.indexOf(new MapEntry<>(key, oldValue)), entry);
        return oldValue;
    }

    @Override
    public V get(Object key) { return super.get(key); }
    @Override
    public Set<K> keySet() {
        return super.keySet();
    }
    @Override
    public void clear() { entries.clear(); }
    class EntrySet extends AbstractSet<Map.Entry<K,V>>{
        private int size;
        public EntrySet() { size = entries.size(); }

        private class Iter implements Iterator<Map.Entry<K,V>>{
            private int counter = -1;
            @Override
            public boolean hasNext() {
                boolean ind = counter < size - 1;
                if (!ind) counter = -1;
                return ind;
            }
            @Override
            public Map.Entry<K,V> next() {
                return entries.get(++counter);
            }
            @Override
            public void remove() {
                int cursor = size - 1;
                entries.remove(cursor);
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