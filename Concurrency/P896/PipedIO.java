package ThinkingInJava.Concurrency.P896;

//Exercise 30: (1) Modify PipedIO.java to use a BlockingQueue instead of a pipe

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
    private Random rand = new Random(47);
    private LinkedBlockingQueue<Character> lbq = new LinkedBlockingQueue<>();
    public LinkedBlockingQueue<Character> getQueue() {
        return lbq;
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                for(char c = 'A'; c <= 'z'; c++) {
                    lbq.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Sender interrupted");
        }
        System.out.println("Sender off");
    }
}
class Receiver implements Runnable {
    Sender sender;
    public Receiver(Sender sender) {
        this.sender = sender;
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println(sender.getQueue().take());
            }
        } catch (InterruptedException e) {
            System.out.println("Receiver interrupted");
        }
        System.out.println("Receiver off");
    }
}
public class PipedIO {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(new Receiver(sender));
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
