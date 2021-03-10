package ThinkingInJava.Concurrency.P882;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Exercise 22: (4) Create an example of a busy wait.
// One task sleeps for a while and then sets a flag to true.
// The second task watches that flag inside a while loop
// (this is the busy wait) and when the flag becomes true,
// sets it back to false and reports the change to the console.
// Note how much wasted time the program spends inside the busy wait,
// and create a second version of the program that uses wait( ) instead of the busy wait
class Switcher implements Runnable {
    private volatile boolean flag = false;
    private Locker2 locker2;
    @Override
    public void run() {
    for( ; ;){
    try {
        TimeUnit.MILLISECONDS.sleep(200);
    } catch (InterruptedException e) { return; }
        flag = true;
        }
    }
    public synchronized boolean getFlag() { return flag; }
    public synchronized void setFlagToFalse() {
        flag = false;
        System.out.println(flag);
    }
    @Override
    public String toString() {
        return "Swither turn " + flag;
    }
}
class Switcher2 implements Runnable {
    @Override
    public void run() {
        for( ; ;){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            synchronized (this) { notifyAll(); }
        } catch (InterruptedException e) {
            System.out.println(e);
            return;
        }
        }
    }
}

class Locker implements Runnable {
    private volatile Switcher switcher;
    public Locker(Switcher switcher) {
        this.switcher = switcher;
    }
    private long duration;
    @Override
    public void run() {
        long start = System.nanoTime();
        for(;;) {
        while (true) {
            if(switcher.getFlag()) {
                switcher.setFlagToFalse();
                duration = System.nanoTime() - start;
                System.out.println(duration);
                return;
            }
        }
        }
    }
    public long getDuration() { return duration > 0 ? duration : -1; }
}
class Locker2 implements Runnable {
    private volatile Switcher2 switcher2;
    private long duration;
    public Locker2(Switcher2 switcher2) {
        this.switcher2 = switcher2;
    }
    @Override
    public void run() {
        long start = System.nanoTime();
        for(; ;) {
            try {
                synchronized (switcher2) { switcher2.wait(); }
            } catch (InterruptedException e) {
                return;
            }
            duration = System.nanoTime() - start;
            System.out.println(duration);
        }
    }
    public synchronized long getDuration() { return duration > 0 ? duration : -1; }
}
public class BusyWait {
    public static void compareDur(long dur1, long dur2) {
        System.out.println(dur1);
        System.out.println(dur2);
        long res =  dur1 - dur2;
        System.out.println(res);
    }
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Switcher switcher = new Switcher();
        Switcher2 switcher2 = new Switcher2();
        Locker locker = new Locker(switcher);
        Locker2 locker2 = new Locker2(switcher2);
        exec.execute(switcher);
        exec.execute(switcher2);
        exec.execute(locker);
        exec.execute(locker2);
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
        compareDur(locker.getDuration(),locker2.getDuration());
    }
}
