package ThinkingInJava.Containers.P305;

import java.util.*;

public class Generator {
    private static int counter = 0;
    private static String[] namesStarWars = {"R2D2", "LukeSkywalker", "Chubaka", "DartVeider", "Yoda", "Jedi"};
    private static String next() {
        if (counter == namesStarWars.length) counter = 0;
        return namesStarWars[counter++];
    }
    public static Collection fill(Collection<String> c, int n) {
        for (int i = 0; i < n; i++)
        c.add(next());
        return c;
    }


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
            fill(arrayList,8);
            fill(linkedList,6);
            fill(hashSet,8);
            fill(treeSet,11);
            fill(linkedHashSet,10);


        for(String s: arrayList){
            System.out.println(s);
        }
    }
}
