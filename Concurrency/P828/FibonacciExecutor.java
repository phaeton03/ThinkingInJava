package ThinkingInJava.Concurrency.P828;

import ThinkingInJava.Concurrency.P826.FibonacciTask;

import java.util.concurrent.*;

//Exercise 4: (1) Repeat Exercise 2 using the different types of executors shown in this section.
public class FibonacciExecutor {
    public static void main(String[] args) {
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(5);
        ExecutorService cacheExecutor = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            cacheExecutor.execute(new FibonacciTask(4));
        singleExecutor.shutdown();
        fixedExecutor.shutdown();
        cacheExecutor.shutdown();
    }
}
