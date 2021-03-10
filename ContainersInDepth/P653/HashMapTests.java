package ThinkingInJava.ContainersInDepth.P653;

//Exercise 38: (3) Look up the HashMap class
// in the JDK documentation. Create a HashMap,
// fill it with elements, and determine the load factor.
// Test the lookup speed with this map, then attempt to
// increase the speed by making a new HashMap with a larger
// initial capacity and copying the old map into the new one,
// then run your lookup speed test again on the new map.

import java.util.HashMap;

public class HashMapTests {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hm1 = new HashMap<>(100);
        HashMap<Integer,Integer> hm2 = new HashMap<>(100,0.5f);
        HashMap<Integer,Integer> hm3 = new HashMap<>(100,0.9f);
    }
}
