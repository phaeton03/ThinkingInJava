package ThinkingInJava.Concurrency.P836;

//Exercise 9: (3) Modify SimplePriorities.java so that
// a custom ThreadFactory sets the priorities of the threads.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class PriorityThreadFactory implements ThreadFactory {
    private final int priority;
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(priority);
        return thread;
    }

    public PriorityThreadFactory(int priority) {
        this.priority = priority;
    }
}

public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority = -1;
    public SimplePriorities() { }
    public SimplePriorities(int priority) {
        this.priority = priority;
    }
    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }
    @Override
    public void run() {
        if(priority >= 0) Thread.currentThread().setPriority(priority);
        while(true) {
            for(int i = 1; i < 100_000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));
        for(int i = 0; i < 5; i++)
            exec.execute(new SimplePriorities());
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));
        exec.execute(new SimplePriorities());
        Thread.yield();
        exec.shutdown();
    }
}

