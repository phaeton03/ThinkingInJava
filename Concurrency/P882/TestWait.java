package ThinkingInJava.Concurrency.P882;

//Exercise 21: (2) Create two Runnables, one with a run( )
// that starts and calls wait( ). The second class should
// capture the reference of the first Runnable object.
// Its run( ) should call notifyAll( ) for the first task
// after some number of seconds have passed so that the first
// task can display a message. Test your classes using an Executor.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Toster implements Runnable {
    volatile boolean flag = true;
    public synchronized void wakeUp() {
        notifyAll();
    }
    public synchronized void waitOff() throws InterruptedException {
        wait();
    }
    @Override
    public void run() {
        try {
        while (flag){
            System.out.println("Before //'wait()//'");
            waitOff();
            System.out.println("After wait");
            }
        } catch (InterruptedException e) {
          System.err.println(e);
        }
    }
}
class SmartHome implements Runnable {
    private Toster toster;
    public SmartHome(Toster toster) {
        this.toster = toster;
    }
    public synchronized void startUp() {
        toster.flag = true;
    }
    public synchronized void wakeUp() {
        System.out.println("Wake up");
        toster.wakeUp();
    }
    @Override
    public void run() {
        try {
            startUp();
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println("after sleep");
            wakeUp();
        //toster.wakeUp();
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            toster.flag = false;
        }
    }
}
public class TestWait {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Toster toster = new Toster();
        exec.execute(toster);
        exec.execute(new SmartHome(toster));
        exec.shutdown();
    }
}
