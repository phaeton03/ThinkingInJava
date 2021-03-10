package ThinkingInJava.Concurrency.P894;

//Exercise 29: (8) Modify ToastOMatic.java to create
// peanut butter and jelly on toast sandwiches using
// two separate assembly lines (one for peanut butter,
// the second for jelly, then merging the two lines).

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Toast {
    public enum Status { DRY, PEANUT, JELLY, READY };
    private Status status = Status.DRY;
    private final int id;
    public Toast(int id) {
        this.id = id;
    }
    public void peanut() { status = Status.PEANUT; }
    public void jelly() { status = Status.JELLY; }
    public void ready() { status = Status.READY; }
    public Status getStatus() { return status; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}
class ToastQueue extends LinkedBlockingQueue<Toast> {}

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);
    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}
class Peanuter implements Runnable {
    private ToastQueue dryQueue, peanutQueue;
    public Peanuter(ToastQueue dryQueue, ToastQueue peanutQueue) {
        this.dryQueue = dryQueue;
        this.peanutQueue = peanutQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();
              //  t.peanut();
                t.peanut();
                System.out.println("peanut" + t);
                peanutQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Peanut interrupted");
        }
        System.out.println("Peanater off");
    }
}
class Jelly implements Runnable {
    ToastQueue peanutQueue, jellyQueue;
    public Jelly(ToastQueue peanutQueue, ToastQueue jellyQueue) {
        this.peanutQueue = peanutQueue;
        this.jellyQueue = jellyQueue;
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Toast t = peanutQueue.take();
                TimeUnit.MILLISECONDS.sleep(10);
                t.jelly();
                System.out.println("jelly)" + t);
                jellyQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jelly interrupted");
        }
        System.out.println("Jelly off");
    }
}
class Alternate implements Runnable {
    ToastQueue dryQueue, toBeJellyQueue, toBePeanutQueue;
    boolean alter;
    public Alternate(ToastQueue dryQueue, ToastQueue toBeJellyQueue, ToastQueue toBePeanutQueue) {
        this.dryQueue = dryQueue;
        this.toBeJellyQueue = toBeJellyQueue;
        this.toBePeanutQueue = toBePeanutQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                 Toast t = dryQueue.take();
                 toBeJellyQueue.put(t);
                 toBePeanutQueue.put(t);
                 alter = !alter;
            }
        } catch (InterruptedException e) {
            System.out.println("Alternate interrupted");
        }
        System.out.println("Alternate off");
    }
}
class Merger implements Runnable {
    ToastQueue toBeJellyQueue,
               toBePeanutQueue,
               finishedQueue;
    public Merger(ToastQueue toBeJellyQueue, ToastQueue toBePeanutQueue, ToastQueue finishedQueue) {
        this.toBeJellyQueue = toBeJellyQueue;
        this.toBePeanutQueue = toBePeanutQueue;
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Toast t = null;
                t = toBeJellyQueue.take();
                if(t == null) break;
                t = toBePeanutQueue.take();
                if(t == null) break;
                t.ready();
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Merger interrupted");
        }
        System.out.println("Merger off");
    }
}
class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter;
    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                Toast t = finishedQueue.take();
                if(t.getStatus() != Toast.Status.READY) {
                    System.out.println(t.getId() + "\\" + counter);
                    System.out.println(">>>> Error: " + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }
}
public class ToastOMatic {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(),
                   toBePeanutQueue = new ToastQueue(),
                   peanutQueue = new ToastQueue(),
                   toBeJellyQueue = new ToastQueue(),
                   jellyQueue = new ToastQueue(),
                   finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Alternate(dryQueue, toBePeanutQueue, toBeJellyQueue));
        exec.execute(new Peanuter(toBePeanutQueue, peanutQueue));
        exec.execute(new Jelly(toBeJellyQueue, jellyQueue));
        exec.execute(new Merger(peanutQueue, jellyQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
