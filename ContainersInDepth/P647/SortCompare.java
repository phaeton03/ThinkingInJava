package ThinkingInJava.ContainersInDepth.P647;
//Exercise 30: (3) Compare the performance of Collections.sort( ) between an ArrayList and a LinkedList.

import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Generics.P475.Generators;

import java.util.*;
public class SortCompare {
    public static void main(String[] args) {
        ListPerfomance.ListTester.run(new ArrayList<Integer>(), ListPerfomance.tests);
        ListPerfomance.ListTester.run(new LinkedList<Integer>(), ListPerfomance.tests);
    }
}
