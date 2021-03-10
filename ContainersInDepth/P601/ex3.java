package ThinkingInJava.ContainersInDepth.P601;

import java.util.*;
public class ex3 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> lnkdHashSet = new LinkedHashSet<>();
        for (int i = 0; i < Countries.DATA.length; i++){
            hashSet.add(Countries.DATA[i][1]);
            treeSet.add(Countries.DATA[i][1]);
            lnkdHashSet.add(Countries.DATA[i][1]);
        }
        System.out.println(hashSet);
        System.out.println(treeSet);
        System.out.println(lnkdHashSet);
    }
}
