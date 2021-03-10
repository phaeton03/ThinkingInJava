package ThinkingInJava.ContainersInDepth.P607;
//Exercise 6: (2) Note that List has additional
// "optional" operations that are not included
// in Collection. Write a version of Unsupported.java
// that tests these additional optional operations.
//Containers
import java.util.*;

public class UnsupportedJava {
    public static void test(String msg, List<Integer> list){
        System.out.println(msg);
        try{
            list.set(1,15);
        }catch (UnsupportedOperationException e){
            System.err.println("list.set(...) - " + e);
        }
         try{
            list.remove(0);
        }catch (UnsupportedOperationException e){
            System.err.println("list.remove(index) - " + e);
        }
        try{
            list.remove(Integer.valueOf(10));
        }catch (UnsupportedOperationException e){
            System.err.println("list.remove(object) - " + e);
        }
    }
    public static void main(String[] args) {
        test("Arrays.asList(10,14,15,22,333))",
               (Arrays.asList(10,14,15,22,333)));
        test("Collections.unmodifiableList(new ArrayList<Integer>(Arrays.asList(5,10,11,111,24325)",
                Collections.unmodifiableList(new ArrayList<Integer>(Arrays.asList(5,10,11,111,24325))));

    }
}
