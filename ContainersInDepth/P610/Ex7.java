package ThinkingInJava.ContainersInDepth.P610;

import java.util.*;
import ThinkingInJava.ContainersInDepth.P601.*;
//Exercise 7: (4) Create both an ArrayList and
// a LinkedList, and fill each using the
// Countries.names( ) generator. Print each
// list using an ordinary Iterator, then insert
// one list into the other by using a Listlterator,
// inserting at every other location. Now perform
// the insertion starting at the end of the first list and moving backward.
public class Ex7 {
    public static void main(String[] args) {
        ArrayList<String> arrList = (ArrayList<String>) Countries.names(10);
        LinkedList<String> linkList = new LinkedList<>(Countries.names(20).subList(10,20));
        Iterator<String> arrIter = arrList.iterator();
        Iterator<String> linkIter = linkList.iterator();
        while(arrIter.hasNext())
            System.out.println(arrIter.next());
        System.out.println("/--------------------------/");
        while (linkIter.hasNext())
            System.out.println(linkIter.next());
        ListIterator<String> listIt = linkList.listIterator();
        Random random = new Random(47);
        while(listIt.hasNext())
            arrList.add(random.nextInt(linkList.size()),listIt.next());
        System.out.println(linkList);
        System.out.println(arrList);
        listIt = linkList.listIterator(linkList.size());
        while(listIt.hasPrevious()) {
            int index = arrList.size();
            arrList.add(index, listIt.previous());
            index = index - 3;
        }
        System.out.println(arrList);
    }
}
