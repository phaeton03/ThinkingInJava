package ThinkingInJava.Arrays.P582;
//Exercise 21: (3) Try to sort an array of the objects in Exercise 18.
// Implement Comparable to fix the problem.
// Now create a Comparator to sort the objects into reverse order.

import ThinkingInJava.Arrays.P576.Berilium;
import ThinkingInJava.Arrays.P576.CountingGenerator;
import ThinkingInJava.Arrays.P576.FillArray;
import ThinkingInJava.Generics.P471.Generator;

import java.util.Arrays;
import java.util.Collections;

public class BeriliumCompare {
    public static void main(String[] args) {
        Berilium[] berArr = FillArray.fillArray(Berilium.class, new CountingGenerator.Berilium(), 5);
        Arrays.sort(berArr, Collections.reverseOrder());
        System.out.println(Arrays.toString(berArr));
    }
}
