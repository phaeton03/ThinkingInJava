package ThinkingInJava.Concurrency.P890;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Exercise 27: (2) Modify Restaurant.java to use explicit Lock and Condition objects.
class Meal {
    private final int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}
class WaitPerson implements Runnable {
    private Restaraunt restaraunt;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public WaitPerson(Restaraunt restaraunt) {
        this.restaraunt = restaraunt;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaraunt.meal == null)
                        condition.await();
                } finally {
                    lock.unlock();
                }
                System.out.println("WaitPerson got " + restaraunt.meal);
                restaraunt.chef.lock.lock();
                try {
                    restaraunt.meal = null;
                    restaraunt.chef.condition.signalAll();
                } finally {
                    restaraunt.chef.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}
class Chef implements Runnable {
    Restaraunt r;
    private int count = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public Chef(Restaraunt r) {
        this.r = r;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (r.meal != null)
                        condition.await();
                } finally {
                    lock.unlock();
                }
                if(++count == 10) {
                    System.out.println("Out of food, closing");
                    r.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                r.waitPerson.lock.lock();
                try {
                    r.meal = new Meal(count);
                    r.waitPerson.condition.signalAll();
                } finally {
                    r.waitPerson.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
public class Restaraunt {
    Meal meal;
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaraunt() {
        exec.execute(waitPerson);
        exec.execute(chef);
    }

    public static void main(String[] args) {
        new Restaraunt();
    }
}
