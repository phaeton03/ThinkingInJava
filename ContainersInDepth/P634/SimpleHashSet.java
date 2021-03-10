package ThinkingInJava.ContainersInDepth.P634;

import java.util.*;
//Exercise 24: (5) Following the example in SimpleHashMap.java, create and test a SimpleHashSet.

public class SimpleHashSet<K> extends AbstractSet<K> {
    static final int SIZE = 997;
    LinkedList<K>[] buckets = new LinkedList[SIZE];

    private Set<K> keySet(){
        HashSet<K> keySet = new HashSet<>();
        for(LinkedList<K> bucket : buckets)
            if(bucket != null)
                keySet.addAll(bucket);
        return keySet;
    }
    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

    @Override
    public boolean add(K k) { // check and correct
        int index = Math.abs(k.hashCode()) % SIZE;
        if(buckets[index] == null) buckets[index] = new LinkedList<>();
        if(!buckets[index].contains(k)) buckets[index].add(k);
        return !buckets[index].contains(k);
    }
    @Override
    public void clear() {
        for(LinkedList<K> bucket : buckets)
            if(bucket != null)
                bucket.clear();
    }
    @Override
    public int size() {
        int size = 0;
        for(LinkedList<K> bucket : buckets)
            if(bucket != null)
            size += bucket.size();
    return size;
    }
    @Override
    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        return buckets[index].remove(o);
    }

    public static void main(String[] args) {
        String text = "Korova korova mu mu mu. What is right, what is wrong. Baby don't hurt me, no more.";
        SimpleHashSet<String> simpleSet = new SimpleHashSet<>();
        simpleSet.addAll(Arrays.asList(text.split("\\W+")));
        simpleSet.add("Uv");
        System.out.println(simpleSet.size());
        Iterator<String> iter = simpleSet.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
}
