package ThinkingInJava.Concurrency.P828;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Exercise 3: (1) Repeat Exercise 1 using the different types of executors shown in this section.
public class TestRunnableExecutor implements Runnable {
    private static int count = 0;
    private final int id = count++;
    public TestRunnableExecutor() {
        System.out.println("Three, two, one - launch!");
    }
    private static void shutdown() {
        System.out.println("System was shut down");
    }
    public void run() {
        System.out.println("TestRunnable " + id);
        Thread.yield();
        System.out.println("id " + id);
        Thread.yield();
        System.out.println("id " + id);
        Thread.yield();
        shutdown();
        return;
    }
    public static void main(String[] args) {
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
        ExecutorService cacheExector = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            fixedExecutor.execute(new TestRunnableExecutor());
        singleExecutor.shutdown();
        fixedExecutor.shutdown();
        cacheExector.shutdown();
    }
}
