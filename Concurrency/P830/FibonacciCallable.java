package ThinkingInJava.Concurrency.P830;

import ThinkingInJava.Generics.P471.IterableFibonachi;

import java.util.concurrent.*;
import java.util.*;
//Exercise 5: (2) Modify Exercise 2 so that the task is a Callable that
// sums the values of all the Fibonacci numbers. Create several tasks and display the results.

public class FibonacciCallable implements Callable<String> {
    private int count;
    public FibonacciCallable(int count) { this.count = count; }
    @Override
    public String call() throws Exception {
        IterableFibonachi fibo = new IterableFibonachi(count);
        int sum = 0;
        for(Integer num : fibo)
            sum += num;
        return sum + "";
    }
    public static void main(String[] args) {
        ArrayList<Future<String>> results = new ArrayList<>();
        ExecutorService cachedService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            results.add(cachedService.submit(new FibonacciCallable(10)));
        for(Future<String> fs : results)
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e){
                System.out.println(e);
            } finally {
                cachedService.shutdown();
            }
    }
}
