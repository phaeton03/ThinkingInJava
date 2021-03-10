package ThinkingInJava.ContainersInDepth.P624;

//Exercise 14: (3) Show that java.util.Properties works in the above program.
import ThinkingInJava.ContainersInDepth.P601.CountingMapData;

import java.util.*;

public class Maps {
    public static void printKeys(Map<Object, Object> map){
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys: ");
        System.out.print(map.keySet());
    }
    public static void test(Map<Object, Object> map){
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        printKeys(map);
        System.out.print("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Object key = map.keySet().iterator().next();
        System.out.println("Print first key: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("\nmap.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(11));
        System.out.println(map);
        map.keySet().removeAll(map.keySet());
        System.out.println(map);
        System.out.println("map.isEmpty(): " + map.isEmpty());
        System.out.println(map);
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        test(properties);
    }
}
