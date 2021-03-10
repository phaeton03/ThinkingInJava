package ThinkingInJava.ContainersInDepth.P634;

import ThinkingInJava.Arrays.P576.RandomGenerator;
import ThinkingInJava.ContainersInDepth.P621.WordOccurence;
import ThinkingInJava.ContainersInDepth.P632.MapEntry;
import ThinkingInJava.Generics.P471.Generator;

import java.util.*;
//Exercise 37: (2) Modify SimpleHashMap to use ArrayLists instead of LinkedLists.
// Modify MapPerformance.java to compare the performance of the two implementations.

public class SimpleHashMap3<K,V> extends AbstractMap<K,V>{
    static final int SIZE = 997; // prime number
    List<MapEntry<K,V>>[] buckets = new ArrayList[SIZE];
    HashMap<String,Integer> hm;

    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) buckets[index] = new ArrayList<>();
        List<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            } //else System.out.println("Collision founded " + index + " " + key + " " + iPair.getKey());
        }
        if(!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }
    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for(List<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    @Override
    public void clear() {
        buckets = new ArrayList[SIZE];
    }

    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        V oldValue = null;
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> pair : buckets[index])
            if(pair.getKey().equals(key)){
                oldValue = pair.getValue();
                buckets[index].remove(pair);
            }
        return oldValue;
    }

    public static void main(String[] args) {
        String text = "Korova korova mu mu mu. What is right, what is wrong. Baby don't hurt me, no more.";
        Generator<String> stringGenerator = new RandomGenerator.RandomString(2);
        SimpleHashMap<String,Integer> shm = WordOccurence.wordCounter2(text);
        SimpleHashMap<String,Integer> shm2 = WordOccurence.wordCounter2(text);
        shm2.put("korova", 1);
        shm2.put("Uv", 1);
        System.out.println(shm2);
        for(int i = 0; i < 80; i++){
            String word = stringGenerator.next();
            shm.put(word, shm.get(word) == null ? 1 : shm.get(word) + 1);
        }
        System.out.println(shm2.remove("Korova"));
        System.out.println(shm2.size());
    }
}
