package ThinkingInJava.Containers.P323;

import java.util.PriorityQueue;
import java.util.Random;

public class Ex28 {
    public static void main(String[] args) {
        PriorityQueue<Double> queueDouble = new PriorityQueue<>();
        for (int i = 0; i < 10; i++){
            Random random = new Random();
            queueDouble.offer(random.nextDouble());
        }
        System.out.println(queueDouble);
        for (int i = 0; i < 10; i++)
            System.out.println(queueDouble.poll());
    }
}
