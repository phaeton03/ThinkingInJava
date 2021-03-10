package ThinkingInJava.ContainersInDepth.P658;

import ThinkingInJava.Arrays.P576.RandomGenerator;
import ThinkingInJava.Generics.P471.Generator;

import java.util.*;

//Exercise 40: (5) Create a class containing two
// String objects and make it Comparable so that
// the comparison only cares about the first String.
// Fill an array and an ArrayList with objects of your class,
// using the RandomGenerator generator. Demonstrate that
// sorting works properly. Now make a Comparator that only
// cares about the second String, and demonstrate that sorting
// works properly. Also perform a binary search using your Comparator.
class Test implements Comparable<Test> {
    String str1, str2;
    private static boolean switchStr = false;
    public Test(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }
    @Override
    public int compareTo(Test test) {
        switchStr = false;
        return str1.toLowerCase().compareTo(test.str1.toLowerCase());
    }

    @Override
    public String toString() {
        return switchStr ? str2 : str1;
    }
    static class CompStr2 implements Comparator<Test> {
        @Override
        public int compare(Test t1, Test t2) {
            switchStr = true;
            return t1.str2.toLowerCase().compareTo(t2.str2.toLowerCase());
        }
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Test && str1.equals(((Test)o).str1)
                && str2.equals(((Test)o).str2);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + str1.hashCode();
        result = 37 * result + str2.hashCode();
        return result;
    }
}
public class Ex40 {
    public static void main(String[] args) {
      Generator<String> gen2 = new RandomGenerator.RandomString(1);
      Generator<String> gen3 = new RandomGenerator.RandomString(3);
      HashSet<Test> set = new HashSet<>();
      Test[] testArr = new Test[20];
      ArrayList<Test> list = new ArrayList<>();
      for(int i = 0; i < 20; i++) {
          list.add(new Test(gen2.next(), gen3.next()));
          testArr[i] = new Test(gen2.next(), gen3.next());
          set.add(new Test(gen2.next(),gen3.next()));
      }
       // System.out.println(set);
       // System.out.println(set.size());
        System.out.println(Arrays.toString(testArr));
        System.out.println(list);
        Collections.sort(list);
        Arrays.sort(testArr);
        System.out.println("After sorting by str1.............");
        System.out.println(Arrays.toString(testArr));
        System.out.println(list);
        System.out.println(Arrays.toString(testArr));
        System.out.println(list);
        Collections.sort(list, new Test.CompStr2());
        Arrays.sort(testArr, new Test.CompStr2());
        System.out.println("After sorting by str2.............");
        System.out.println(Arrays.toString(testArr));
        System.out.println(list);
    }
}
