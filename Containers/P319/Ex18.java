package ThinkingInJava.Containers.P319;

import java.util.*;
public class Ex18 {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("Three",3 );
        map.put("One",1 );
        map.put("Two",2 );
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        Set keys = map.keySet();
        ArrayList<String> keysSort = new ArrayList<>(keys);
        Collections.sort(keysSort);
        System.out.println(map);
        for (String s : keysSort)
            linkedHashSet.add(s);
            //hashSet.add(s);
            //linkedMap.put(s, map.get(s));
        System.out.println(linkedHashSet);
    }
}
