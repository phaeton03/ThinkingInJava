package ThinkingInJava.ContainersInDepth.P601;
import java.util.*;
//Exercise 1: (1) Create a List
// (try both ArrayList and LinkedList)
// and fill it using Countries. Sort the
// list and print it, then apply Collections.shuffle( )
// to the list repeatedly, printing it each time so
// that you can see how the shuffle( ) method randomizes the list differently each time.
public class Ex1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Countries.DATA.length; i++){
            list.add(Countries.DATA[i][0]);
            linkedList.add(Countries.DATA[i][0]);
        }
        Collections.shuffle(list);
        System.out.println(list);
        Collections.shuffle(linkedList);
        System.out.println(linkedList);
        HashMap<Integer,String> hm = new HashMap<>();
        Set<Map.Entry<Integer,String>> set = hm.entrySet();
        Iterator<Map.Entry<Integer,String>> it = hm.entrySet().iterator();
    }
}
