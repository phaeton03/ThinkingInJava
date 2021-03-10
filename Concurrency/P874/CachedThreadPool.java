package ThinkingInJava.Concurrency.P874;

//Exercise 20: (1) Modify CachedThreadPool.java so
// that all tasks receive an interrupt( ) before they are completed.

import ThinkingInJava.Concurrency.P836.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPool {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
            //TimeUnit.MILLISECONDS.sleep(100);
        }
        exec.shutdownNow();
        //exec.shutdown();

        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Not all tasks were terminated");
    }
}
