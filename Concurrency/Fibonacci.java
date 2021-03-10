package ThinkingInJava.Concurrency;

//Exercise 2: (2) Following the form of generics/Fibonacci.java,
// create a task that produces a sequence of n Fibonacci numbers,
// where n is provided to the constructor of the task. Create a
// number of these tasks and drive them using threads.

import ThinkingInJava.Generics.P471.IterableFibonachi;

public class Fibonacci implements Runnable {
    private int seq;
    public Fibonacci(int n) {
        seq = n;
    }
    public void run() {
        IterableFibonachi fibonachi = new IterableFibonachi(seq);
        for(Integer i : fibonachi)
            System.out.println(i);
        Thread.yield();
    }
}
