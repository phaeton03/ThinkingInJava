package ThinkingInJava.Concurrency.P859;

//Exercise 14: (4) Demonstrate that java.util.Timer scales
// to large numbers by creating a program that
// generates many Timer objects that perform some simple task when the timeout completes

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.*;

public class TimerTest {
    private static AtomicInteger id = new AtomicInteger(0);
    public static void test(int count) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.err.println("Aborting id: " + id.addAndGet(1));
               //     Thread.yield();
                    return;
                }
            }, 1000);
        }
    public static void main(String[] args) {
        for(int i = 0; i < 150; i++)
        test(10);
    }
}
