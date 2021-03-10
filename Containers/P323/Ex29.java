package ThinkingInJava.Containers.P323;

import java.util.PriorityQueue;

public class Ex29 implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void main(String[] args) {
        PriorityQueue<Ex29> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++)
            queue.offer(new Ex29());
    }
}
