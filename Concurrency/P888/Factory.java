package ThinkingInJava.Concurrency.P888;

//Exercise 24: (1) Solve a single-producer, single-consumer
// problem using wait( ) and notifyAll( ). The producer
// must not overflow the receiver’s buffer, which can
// happen if the producer is faster than the consumer.
// If the consumer is faster than the producer, then
// it must not read the same data more than once.
// Do not assume anything about the relative speeds of the producer or consumer
//Exercise 26: (8) Add a BusBoy class to Restaurant.java. After the meal is
// delivered, the WaitPerson should notify the BusBoy to clean up.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Item {
    private final int num;
    public Item(int num) {
        this.num = num;
    }
    @Override
    public String toString() { return "Item " + num; }
}
class BusBoy implements Runnable {
    private Factory factory;
    boolean notified;
    public BusBoy(Factory factory) { this.factory = factory; }
    @Override
    public void run() {
            try {
                while (!Thread.interrupted()) {
                synchronized (this) {
                    if(!notified)
                    wait();
                    notified = false;
                }
                System.err.println("GGGG" + factory.item);
                System.out.printf("After item %s was cleaned", factory.item);
                synchronized (factory.worker) {
                    factory.item = null;
                    factory.worker.notifyAll();
                }
              }
            } catch (InterruptedException e) {
                System.out.println("BusBoy interrupted");
        //        return;
            }
        }
    }

class Worker implements Runnable {
    private Factory factory;
    private int count = 0;
    public Worker(Factory factory) {
        this.factory = factory;
    }
    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                System.out.println("Making item...");
                synchronized (this) {
                    while(factory.item != null)
                    wait();
                }
                if(++count == 10) {
                System.out.println("Out of stock");
                factory.exec.shutdownNow();
                return;
                }
                System.out.println("New delivery! ");
                synchronized (factory.truck) {
                    factory.item = new Item(count);
                    factory.truck.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(200);
            } catch(InterruptedException e) {
                System.out.println("Worker interrupted");
            }
        }
    }
}
class Truck implements Runnable {
    private Factory factory;
    private boolean notified = true;
    public Truck(Factory factory) {
        this.factory = factory;
    }
    @Override
    public void run() {
        try {
        while(!Thread.interrupted()) {
                System.out.println("Waiting for item");
                synchronized(this) {
                    while (factory.item == null)
                        wait();
                }
            System.out.println("Truck got " + factory.item);
                synchronized (factory.busBoy) {
                    notified = true;
                    factory.busBoy.notifyAll();
                }
                synchronized (this) {
                    if(notified)
                    wait();
                    notified = false;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Truck interrupted");
        }
    }
}
public class Factory {
    Item item;
    Truck truck = new Truck(this);
    BusBoy busBoy = new BusBoy(this);
    Worker worker = new Worker(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    public Factory() {
        exec.execute(busBoy);
        exec.execute(truck);
        exec.execute(worker);
    }
    public static void main(String[] args) throws Exception {
        new Factory();
    }
}
