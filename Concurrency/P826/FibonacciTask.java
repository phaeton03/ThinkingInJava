package ThinkingInJava.Concurrency.P826;

//Exercise 2: (2) Following the form of generics/Fibonacci.java,
// create a task that produces a sequence of n Fibonacci numbers,
// where n is provided to the constructor of the task. Create a
// number of these tasks and drive them using threads.


import ThinkingInJava.Generics.P471.IterableFibonachi;

public class FibonacciTask implements Runnable{
    private int count;
    public FibonacciTask(int n) {
        count = n;
    }
    @Override
    public void run() {
        IterableFibonachi fibonachi = new IterableFibonachi(count);
        for (Integer numFib : fibonachi)
            System.out.println(numFib);
        System.out.println("--------------------------");
      //  Thread.yield();
    }

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
        new Thread(new FibonacciTask(i + 3)).start();
    }
}
