package ThinkingInJava.ContainersInDepth.P615;
import java.util.*;
import ThinkingInJava.Arrays.P576.*;
import ThinkingInJava.Generics.P471.Generator;

//Exercise 9: (2) Use RandomGenerator.
// String to fill a TreeSet, but use alphabetic ordering.
// Print the TreeSet to verify the sort order.

public class Ex9 {
    public static void main(String[] args) {
        SortedSet<String> ss = new TreeSet<>();
        TreeSet<String> alphOrder = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Generator<String> genString = new RandomGenerator.RandomString(4);
        for(int i = 0; i < 5; i++)
            alphOrder.add(genString.next());
        System.out.println(alphOrder);
    }
}
