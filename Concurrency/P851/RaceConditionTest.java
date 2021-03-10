package ThinkingInJava.Concurrency.P851;

//Exercise 11: (3) Create a class containing two data fields,
// and a method that manipulates those fields in a multistep
// process so that, during the execution of that method, those
// fields are in an "improper state" (according to some definition
// that you establish). Add methods to read the fields, and
// create multiple threads to call the various methods and show
// that the data is visible in its "improper state." Fix the problem using the synchronized keyword.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Equality {
    private long count = 0;
    private long num = 0;
    public synchronized void test() {
        count++;
        Thread.yield();
        num++;
    }
    public synchronized long getCount() {
        return count;
    }
    public synchronized long getNum() {
        return num;
    }
    public synchronized boolean validate() { return num == count; }
}

class ConsistencyChecker implements Runnable {
    private Equality equality;
    public ConsistencyChecker(Equality equality) {
        this.equality = equality;
    }
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while(true) {
            equality.test();
            if(!equality.validate()) {
                throw new IllegalStateException("Count " + equality.getCount() +
                        " != Num " + equality.getNum());
            } else if (System.currentTimeMillis() - start > 100000) {
                System.err.println("Time is out " + "Count " + equality.getCount() +
                        " == Num " + equality.getNum());
                break;
            }
        }
    }
    public static void test(ConsistencyChecker cc, int count) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < count; i++)
            exec.execute(cc);
        exec.shutdown();
    }
    public static void test(int count) {
        test(new ConsistencyChecker(new Equality()), count);
    }
}
public class RaceConditionTest {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
       // for(int i = 0; i < 100; i++)
        ConsistencyChecker.test(10);
    }
}
