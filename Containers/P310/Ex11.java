package ThinkingInJava.Containers.P310;

import java.util.*;

public class Ex11 {
    public static void print(Collection c) {
        Iterator it = c.iterator();
        while(it.hasNext())
        System.out.println(it.next());
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(4,6,7,88,999,66,0));
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("The world is mine".split(" ")));
        HashSet<Double> hashSet = new HashSet<>(Arrays.asList(0.8,6.6,8.9));
        TreeSet<Float> treeSet = new TreeSet<>(Arrays.asList(0.1f,0.6f,6.5f));
        LinkedHashSet<Ex11> linkedHashSet = new LinkedHashSet<>(Arrays.asList(new Ex11(), new Ex11()));
        print(arrayList);
        print(linkedList);
        print(hashSet);
        print(treeSet);
        print(linkedHashSet);
    }
}
