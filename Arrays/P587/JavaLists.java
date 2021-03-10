package ThinkingInJava.Arrays.P587;
import java.util.*;

class MyList<T> extends ArrayList<T>{
    public void getReversed(){
        Collections.reverse(this);
    }
}
public class JavaLists {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list);
        list.add(6);
        Collections.addAll(list,7,8);
        System.out.println(list);
        List<Integer> subList = list.subList(3,6);
        System.out.println(subList);
        MyList<Integer> myList = new MyList<>();
        myList.add(7);
        myList.add(6);
        myList.add(5);
        System.out.println(myList);
        myList.getReversed();
        System.out.println(myList);
     }
}
