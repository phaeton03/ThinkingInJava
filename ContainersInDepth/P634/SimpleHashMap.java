package ThinkingInJava.ContainersInDepth.P634;

import ThinkingInJava.Arrays.P576.RandomGenerator;
import ThinkingInJava.ContainersInDepth.P621.WordOccurence;
import ThinkingInJava.ContainersInDepth.P632.MapEntry;
import ThinkingInJava.Generics.P471.Generator;

import java.util.*;
//Exercise 19: (1) Repeat Exercise 13 using a SimpleHashMap.
//------------------------------
//Exercise 13: (4) Use AssociativeArray Java to create a
// wordoccurrence counter, mapping String to Integer.
// Using the net.mindview.util.TextFile utility in this book,
// open a text file and break up the words in that file using
// whitespace and punctuation, and count the occurrence of the words in that file.

//Exercise 39: (6) Add a private rehash( ) method to SimpleHashMap that is
// invoked when the load factor exceeds 0.75. During rehashing, double the number of
// buckets, then search for the first prime number greater than that to determine the new number of buckets.

public class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    static final int SIZE = 997; // prime number
    private final static int initialCapacity = SIZE;
    private int capacity = initialCapacity;
    private float loadFactor = 0.75f;
    private int threshold = (int) (capacity * loadFactor);
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    HashMap<String,Integer> hm;
    private void rehash(){
        int capacity = 2 * buckets.length;
        while(!checkPrime(capacity))
            capacity++;
        LinkedList<MapEntry<K,V>>[] oldBuckets = buckets;
        buckets = new LinkedList[capacity];
        System.out.println(capacity);
        for(LinkedList<MapEntry<K,V>> cont : oldBuckets) {
            if(cont != null)
            for(MapEntry<K,V> entry : cont)
                put(entry.getKey(), entry.getValue());
        }
        System.out.println("rehash : capacity : " + capacity);
    }
    private boolean checkPrime(long n){
        for(int i = 2; i * i < n; i++)
            if(n % i == 0) return false;
        return true;
    }
    private boolean loadFactor() {
        return (float) size() / buckets.length >= loadFactor; // лучше перевести в умножение через threshold
    }
    public V put(K key, V value) {
        if (loadFactor()) rehash();
        int size = buckets.length;
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % size;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
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
            } //else System.out.println("Collision founds " + index + " " + key + " " + iPair.getKey());
        }
        if(!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }
    public V get(Object key){
        int size = buckets.length;
        int index = Math.abs(key.hashCode()) % size;
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
            return iPair.getValue();
        return null;
    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    @Override
    public void clear() {
        for(LinkedList<MapEntry<K,V>> bucket : buckets)
            if(bucket != null) bucket.clear();
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
        for(int i = 0; i < 8000; i++){
            String word = stringGenerator.next();
            shm.put(word, shm.get(word) == null ? 1 : shm.get(word) + 1);
        }
      //  System.out.println(shm2.remove("Korova"));
        System.out.println(shm.size());
    }
}
