package ThinkingInJava.Concurrency.P826;

//Exercise 1: (2) Implement a Runnable. Inside run( ), print a message,
// and then call yield( ). Repeat this three times, and then return
// from run( ). Put a startup message in the constructor and a
// shutdown message when the task terminates. Create a number of
// these tasks and drive them using threads


public class TestRunnable implements Runnable {
    private static int count = 0;
    private final int id = count++;
    public TestRunnable() {
        System.out.println("Three, two, one - launch!");
    }
    private static void shutdown() {
        System.out.println("System was shut down");
    }
    public void run() {
        System.out.println("TestRunnble " + id);
        Thread.yield();
        System.out.println("id " + id);
        Thread.yield();
        System.out.println("id " + id);
        Thread.yield();
        shutdown();
        return;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new Thread(new TestRunnable()).start();
    }
}
