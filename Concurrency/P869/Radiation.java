package ThinkingInJava.Concurrency.P869;

//Exercise 17: (2) Create a radiation counter
// that can have any number of remote sensors.

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Count {
    private int count = 0;
    private Random random = new Random();
    public synchronized int increment() {
        int temp = count;
        if(random.nextBoolean())
            Thread.yield();
        return count = ++temp;
    }
    public synchronized int value() {
        return count;
    }
}

class Sensor implements Runnable {
    private static Random random = new Random(47);
    private static Count count = new Count();
    private static List<Sensor> sensors = new ArrayList<>();
    private int number;
    private final int id;
    private static volatile boolean canceled = false;
    public Sensor(int id) {
        this.id = id;
        sensors.add(this);
    }
    public static void cancel() { canceled = true; }

    @Override
    public void run() {
        while(!canceled) {
            if(random.nextInt(5) == 0) {
                synchronized (this) { ++number; }
                count.increment();
            }
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
    }
    public synchronized int getValue() { return number; }

    @Override
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumSensors() {
        int sum = 0;
        for(Sensor sensor : sensors)
            sum += sensor.getValue();
        return sum;
    }
}
public class Radiation {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new Sensor(i));
        TimeUnit.SECONDS.sleep(3);
        Sensor.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated!");
        System.out.println("Total: " + Sensor.getTotalCount());
        System.out.println("Sum of Sensors: " + Sensor.sumSensors());
    }
}
