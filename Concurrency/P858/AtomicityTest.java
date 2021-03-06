package ThinkingInJava.Concurrency.P858;

//Exercise 12: (3) Repair AtomicityTest.java using
// the synchronized keyword. Can you demonstrate that it is now correct?

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;
    public synchronized int getValue() { return i; }
    private synchronized void evenIncrement() {
    i++;
    Thread.yield();
    i++;
    }
    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        System.out.println(2 % 10);
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if(val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
