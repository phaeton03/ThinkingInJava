package ThinkingInJava.ContainersInDepth.P634;

import ThinkingInJava.ContainersInDepth.P632.MapEntry;

import java.util.Iterator;

public class MapEntry2<K,V> extends MapEntry<K,V> {
    MapEntry2<K,V> next;
    MapEntry2<K,V> c;
    public MapEntry2(K key, V value) {
        super(key, value);
    }
    public long size(){
        return next == null ? 1 : 1 + next.size();
    }
    public MapEntry2<K,V> next(){
        c = next;
        c = c.next;
        return c;
    }
}
