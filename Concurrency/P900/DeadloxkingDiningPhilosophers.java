package ThinkingInJava.Concurrency.P900;

//Exercise 31: (8) Change DeadlockingDiningPhilosophers.java
// so that when a philosopher is done with its chopsticks,
// it drops them into a bin. When a philosopher wants to eat,
// it takes the next two available chopsticks from the bin.
// Does this eliminate the possibility of deadlock? Can you
// reintroduce deadlock by simply reducing the number of available chopsticks?

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Bin {
    private final int cap = 5;
    private static int takeI = 0;
    private static int dropI = 0;
    private LinkedBlockingQueue<Chopstick> queue = new LinkedBlockingQueue<>();

    public void put(Chopstick ch) throws InterruptedException {
        queue.put(ch);
    }
    public Chopstick get() throws InterruptedException{
        return queue.take();
    }
}

class Chopstick {
    private final int id;
    public Chopstick(int id) {
        this.id = id;
    }
    private volatile boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
        System.out.println("take() " + id);
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
        System.out.println("drop() " + id);
    }

    @Override
    public String toString() {
        return "Chopstick " + id;
    }
}
class Philosopher implements Runnable {
    private Bin bin;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);
    private void pause() throws InterruptedException {
        if(ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }
    public Philosopher(Bin bin, int id, int ponderFactor) {
        this.bin = bin;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                Chopstick c1 = bin.get();
                System.out.println(this + " " + " waiting for another one");
                Chopstick c2 = bin.get();
                System.out.println(this + " has " + c2);
                System.out.println(this + " eating");
                pause();
                bin.put(c1);
                bin.put(c2);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " " + "exiting via interrupted");
        }
    }
    @Override
    public String toString() {
        return "Philosopher2 " + id;
    }
}
public class DeadloxkingDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        Bin bin = new Bin();
        int size = 1;
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < size; i++)
            bin.put(new Chopstick(i));
        for(int i = 0; i < size; i++)
            exec.execute(new Philosopher(bin, i, 5));
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}
