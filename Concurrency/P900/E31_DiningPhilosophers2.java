package ThinkingInJava.Concurrency.P900;

import java.util.concurrent.*;
import java.util.*;
class Chopstick2 {
    private final int id;
    private boolean taken;
    public Chopstick2(int ident) { id = ident; }
    public synchronized
    void take() throws InterruptedException {
        while(taken)
            wait();
        taken = true;
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
    public String toString() { return "Chopstick2 " + id; }
}
class ChopstickQueue extends LinkedBlockingQueue<Chopstick2> {}
class ChopstickBin {
    private ChopstickQueue bin = new ChopstickQueue();
    public Chopstick2 get() throws InterruptedException {
        return bin.take();
    }
    public void
    put(Chopstick2 stick) throws InterruptedException {
        bin.put(stick);
    }
}
class Philosopher2 implements Runnable {
    private static Random rand = new Random(47);
    private final int id;
    private final int ponderFactor;
    private ChopstickBin bin;
    private void pause() throws InterruptedException {
        if(ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(
                rand.nextInt(ponderFactor * 250));
    }
    public Philosopher2(ChopstickBin bin, int ident,
                        int ponder) {
        this.bin = bin;
        id = ident;
        ponderFactor = ponder;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
// Get one chopstick from the bin
                Chopstick2 c1 = bin.get();
                System.out.println(this + " has " + c1 +
                        " waiting for another one");
// Get another chopstick from bin
                Chopstick2 c2 = bin.get();
                System.out.println(this + " has " + c2);
                System.out.println(this + " eating");
                pause();
// Put the chopsticks back in bin.
                bin.put(c1);
                bin.put(c2);
            }
        } catch(InterruptedException e) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }
    public String toString() { return "Philosopher2 " + id; }
}
public class E31_DiningPhilosophers2 {
    public static void main(String[] args) throws Exception {
        ChopstickBin bin = new ChopstickBin();
        int size = 5;
        int ponder = 1;
        for(int i = 0; i < size; i++)
            bin.put(new Chopstick2(i));
// One additional chopstick guarantees that at least
// one philosopher can eat without blocking.
//      bin.put(new Chopstick2(size));
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < size; i++)
            exec.execute(new Philosopher2(bin, i, ponder));
            TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
