package ThinkingInJava.Arrays.P576;

import java.util.*;
//Exercise 12:   (1) Create an initialized array of
// double using CountingGenerator. Print the results.
public class Berilium implements Comparable<Berilium>{
    private static Random random = new Random(47);
    private static int id = 0;
    public final int value = random.nextInt(100);
    @Override
    public String toString() {
        return "Berilium # " + value;
    }

    @Override
    public int compareTo(Berilium o) {
        return value < o.value ? -1 : (value == o.value) ? 0 : 1;
    }
}
