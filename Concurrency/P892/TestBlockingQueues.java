package ThinkingInJava.Concurrency.P892;

//Exercise 28: (3) Modify TestBlockingQueues.java by adding
// a new task that places LiftOff on the BlockingQueue,
// instead of doing it in main( ).

import ThinkingInJava.Concurrency.P836.LiftOff;
import ThinkingInJava.InnerClasses.P272.Inter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }
    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }
    @Override
    public void run() {
     try {
         while(!Thread.interrupted()) {
             LiftOff rocket = rockets.take();
             rocket.run();
         }
     } catch (InterruptedException e) {
         System.out.println("Waking from take()");
     }
        System.out.println("Exiting LiftOffRunner");
    }
}
class TestRunner implements Runnable {
    Thread t;
    public TestRunner() {
      t = new Thread(this);
      t.start();
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                TestBlockingQueues.test("LinkedBlockingQueue", new LinkedBlockingQueue<>());
                TestBlockingQueues.test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3));
                TestBlockingQueues.test("SynchronusQueue", new SynchronousQueue<>());
                System.err.println("THE END");
                t.interrupt();
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
public class TestBlockingQueues {
    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }
    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i = 0; i < 5; i++)
                runner.add(new LiftOff(5));
        getKey("Press 'Enter'(" + msg +")");
        t.interrupt();
        System.out.println("Finished " + msg + "test");
    }

    public static void main(String[] args) {
/*        test("LinkedBlockingQueue", new LinkedBlockingQueue<>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3));
        test("SynchronusQueue", new SynchronousQueue<>()); */
        new TestRunner();
    }
}
