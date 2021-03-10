package ThinkingInJava.ContainersInDepth.P634;

import ThinkingInJava.Arrays.P576.RandomGenerator;
import ThinkingInJava.ContainersInDepth.P621.WordOccurence;
import ThinkingInJava.ContainersInDepth.P632.MapEntry;
import ThinkingInJava.ContainersInDepth.P632.SlowMap2;
import ThinkingInJava.Generics.P471.Generator;

import java.util.*;
//Exercise 25: (6) Instead of using a Listlterator
// for each bucket, modify MapEntry so that it is a
// self-contained singly linked list (each MapEntry
// should have a forward link to the next MapEntry).
// Modify the rest of the code in SimpleHashMap.java
// so that this new approach works correctly.

public class SimpleHashMap2<K,V> extends AbstractMap<K,V> {

    static final int SIZE = 997; // prime number
    MapEntry2<K,V>[] buckets = new MapEntry2[SIZE];

    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new MapEntry2<>(key, value);
        MapEntry2<K,V> pair = new MapEntry2<>(key,value);
        MapEntry2<K,V> iPrev = null;
        boolean found = false;
         for (MapEntry2<K,V> iPair = buckets[index]; iPair != null; iPair = iPair.next){
            if(iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                iPair.setValue(value);
                found = true;
                break;
            }
            iPrev = iPair;
           // System.out.println("Collision founds " + index + " " + key + " " + iPair.getKey());
        }
        if(!found){
            iPrev.next = pair;
        }
        return oldValue;
    }
    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for (MapEntry2<K,V> iPair = buckets[index]; iPair != null; iPair = iPair.next)
            if (iPair.getKey().equals(key)) return iPair.getValue();
        return null;
    }
    class EntrySet extends AbstractSet<Map.Entry<K,V>>{
        private class Iter implements Iterator<Map.Entry<K,V>>{
            private int counter = 0;
            private int size = SIZE - 1;
            MapEntry2<K,V> curr = buckets[counter];
            @Override
            public boolean hasNext() {
                while(counter < SIZE)
                    if (curr == null ){
                        if(counter == SIZE - 1) return false;
                        curr = buckets[counter++];
                    }
                    else break;
                return counter < SIZE || curr != null;
            }
            @Override
            public MapEntry2<K, V> next() {
                MapEntry2<K,V> last;
                while (curr == null && counter < SIZE - 1)
                    curr = buckets[counter++];
                if (curr == null) throw new NoSuchElementException();
                last = curr;
                curr = curr.next;
                return last;
            }
            @Override
            public void remove() {
                while (size >= 0 && buckets[size] == null)
                    size--;
                if (size >= 0) buckets[size] = buckets[size].next;
            }
        }

        @Override
        public int size() {
            int size = 0;
            for (MapEntry2<K,V> bucket : buckets){
                if(bucket != null)
                size += bucket.size();
            }
            return size;
        }
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iter();
        }
    }
    public Set<Map.Entry<K,V>> entrySet() { return new EntrySet(); }
    @Override
    public void clear() {
        for(int index = 0; index < SIZE; index++)
            buckets[index] = null;
    }

    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        V oldValue = null;
        if (buckets[index] == null) return null;
        if (buckets[index].getKey().equals(key)) {
            oldValue = buckets[index].getValue();
            buckets[index] = buckets[index].next;
            return oldValue;
        }

        for (MapEntry2<K, V> iPair = buckets[index]; iPair != null; iPair = iPair.next) {
            if (iPair.next.getKey().equals(key)) {
                oldValue = iPair.next.getValue();
                iPair.next = iPair.next.next;
                break;
            }
        }
        return oldValue;
    }
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("String",10);
        Iterator<Map.Entry<String,Integer>> hmI = hm.entrySet().iterator();
        System.out.println(hmI.next());
      //  System.out.println(hmI.next());
        String text = "Korova korova mu mu mu. What is right, what is wrong. Baby don't hurt me, no more.";
        Generator<String> stringGenerator = new RandomGenerator.RandomString(10);
        SimpleHashMap2<String,Integer> shm = WordOccurence.wordCounter3(text);
        SimpleHashMap2<String,Integer> shm2 = WordOccurence.wordCounter3(text);
        SimpleHashMap2<String,Integer> shm3 = new SimpleHashMap2<>();
        shm3.put("g",1);
        Iterator<Map.Entry<String,Integer>> iter3 = shm3.entrySet().iterator();
        System.out.println(iter3.next());
        System.out.println(iter3.next());
        System.out.println("\\-------------------\\");
        shm2.put("korova", 1);
        shm2.put("Uv", 1);
        //System.out.println(shm);
        for(int i = 0; i < 8; i++){
            String word = stringGenerator.next();
            shm.put(word, shm.get(word) == null ? 1 : shm.get(word) + 1);
        }

        Iterator<Map.Entry<String,Integer>> iter = shm.entrySet().iterator();
        while (iter.hasNext())
        System.out.println(iter.next());
        System.out.println(shm);
        System.out.println(shm.size());
        // while (iter.hasNext())
            //System.out.println(iter.next());
        System.out.println(shm2.remove("mu"));
        shm.clear();
        System.out.println(shm.isEmpty());
        System.out.println(shm);
        System.out.println(shm.size());
    }
}
