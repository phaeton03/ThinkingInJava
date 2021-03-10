package ThinkingInJava.ContainersInDepth.P632;
import java.util.*;

public class MapEntryComp<K extends Comparable<K>,V> implements Map.Entry<K,V>, Comparable<K> {
    K key;
    V value;
    public MapEntryComp(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(K k) {
        return key.compareTo(k);
    }

    @Override
    public K getKey() { return key; }
    @Override
    public V getValue() { return value; }
    @Override
    public V setValue(V value) {
        V result = value;
        this.value = value;
        return result;
    }
    public int hashcode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }
    public boolean equals(Object o) {
        if(!(o instanceof MapEntry)) return false;
        MapEntry me = (MapEntry) o;
        return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                (value == null ? me.getValue() == null : value.equals(me.getValue()));
    }
    public String toString() { return key + "=" + value; }
}
