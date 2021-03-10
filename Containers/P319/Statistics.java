package ThinkingInJava.Containers.P319;

import java.util.*;

public class Statistics {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Integer> statistics = new HashMap<>();
        for (int i = 0; i < 10_000; i++){
            int number = random.nextInt(10);
            Integer freq = statistics.get(number);
            statistics.put(number, freq == null ? 1 : freq + 1);
        }
        System.out.println(statistics);
    }
}
