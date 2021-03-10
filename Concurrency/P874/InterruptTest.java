package ThinkingInJava.Concurrency.P874;

//Exercise 18: (2) Create a non-task class
// with a method that calls sleep( ) for a
// long interval. Create a task that calls
// the method in the non-task class. In main( ),
// start the task, then call interrupt( ) to terminate
// it. Make sure that the task shuts down safely.

import java.util.concurrent.TimeUnit;

class Sleeper {
    Thread thread1;
    public Sleeper() {
        thread1 = new Thread() {
            public void run() {
                toSleep();
            }
        };
    }

    public void toSleep() {
        try {
        TimeUnit.SECONDS.sleep(1);
            System.out.println("THE END");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
public class InterruptTest {
    public static void main(String[] args) {
       Sleeper sleeper = new Sleeper();
       sleeper.thread1.start();
       sleeper.thread1.interrupt();
    }
}
