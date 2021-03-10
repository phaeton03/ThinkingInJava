package ThinkingInJava.ContainersInDepth.P617;

//Exercise 11: (2) Create a class that
// contains an Integer that is initialized
// to a value between o and 100 using java.util.Random.
// Implement Comparable using this Integer field.
// Fill a PriorityQueue with objects of your class,
// and extract the values using poll( ) to show that it produces the expected order.

import java.util.*;

class IntegerField implements Comparable<IntegerField>{
    private Random random = new Random();
    Integer num;
    public IntegerField() { num = random.nextInt(100); }

    @Override
    public int compareTo(IntegerField intField) {
        return num > intField.num ? 1 : (num == intField.num ? 0 : -1);
    }

    @Override
    public String toString() {
        return num.toString();
    }
}

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<IntegerField> queue = new PriorityQueue<>();
        for (int i = 0; i < 8; i++)
        queue.offer(new IntegerField());
        for (int i = 0; i < queue.size(); i++){
            System.out.println(queue.poll());
            System.out.println(queue.peek());
        }
    }
}
