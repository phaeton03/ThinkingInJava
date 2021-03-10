package ThinkingInJava.Arrays.P584;
//Exercise 22: (2) Show that the results of performing a binarySearch( )
// on an unsorted array are unpredictable.

import ThinkingInJava.Arrays.P576.CountingGenerator;
import ThinkingInJava.Arrays.P576.FillArray;
import ThinkingInJava.Arrays.P576.PrimitiveConverter;
import ThinkingInJava.Arrays.P576.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        Integer[] intArr = FillArray.fillArray(Integer.class,
                new RandomGenerator.RandomInteger(),10);
        Arrays.sort(intArr, Collections.reverseOrder());
        int location = Arrays.binarySearch(intArr,58, Collections.reverseOrder());
        System.out.println(Arrays.toString(intArr));
        System.out.println(location);
    }
}
