package ThinkingInJava.Concurrency.P841;

//Exercise 10: (4) Modify Exercise 5 following the
// example of the ThreadMethod class, so that runTask( )
// takes an argument of the number of Fibonacci numbers
// to sum, and each time you call runTask( ) it returns
// the Future produced by the call to submit( ).

import ThinkingInJava.Concurrency.P830.FibonacciCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.*;

public class ThreadMethodFibonachi {

    ExecutorService cachedService;
    public Future<String> runTask(int count) {
        cachedService = Executors.newCachedThreadPool();
        Future<String> fs = cachedService.submit(new FibonacciCallable(count));
        cachedService.shutdown();
        return fs;
    }

    public static void main(String[] args) {
        ArrayList<Future<String>> list = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            try {
                System.out.println(new ThreadMethodFibonachi().runTask(10).get());
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            }
    }
}
