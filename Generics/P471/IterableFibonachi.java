package ThinkingInJava.Generics.P471;

import java.util.*;

class Fibonachi {
    private int count = 0;
    public Integer next(){ return fib(count++); }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n - 2) + fib( n -1 );
    }
}
public class IterableFibonachi implements Iterable<Integer>{
    Fibonachi fibonachi = new Fibonachi();
    private int n;
    public IterableFibonachi(int count) {
         n = count;
    }
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            public boolean hasNext(){ return n > 0;}
            public Integer next(){
                n--;
                return fibonachi.next();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        Fibonachi fibo = new Fibonachi();
        IterableFibonachi ib = new IterableFibonachi(10);
        Iterator<Integer> it = ib.iterator();
        for(Integer i : ib)
        System.out.print(i + " ");
    }
}
