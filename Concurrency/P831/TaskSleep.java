package ThinkingInJava.Concurrency.P831;

//Exercise 6: (2) Create a task that sleeps for a random amount
// of time between 1 and 10 seconds, then displays its sleep
// time and exits. Create and run a quantity (given on the command line) of these tasks.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskSleep implements Runnable{
    private static int count = 0;
    private final int counter = count++;
    @Override
    public void run() {
        try{
        System.out.println("id : " + counter);
        System.out.println("id : " + counter);
        System.out.println("id : " + counter);
        TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new TaskSleep());
        exec.shutdown();
    }
}
