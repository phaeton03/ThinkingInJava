package ThinkingInJava.Generics;

import java.util.*;

class A {
    private static int count = 0;
    private int counter = ++count;
    @Override
    public String toString() {
        return "Instance of class A  number = " + counter;
    }
}

class Holder<T> {
    private T a1, a2, a3;
    private T[] arrA = (T[]) new Object[3];

    public Holder(T a1, T a2, T a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        addA();
    }

    private void addA() {
        arrA[0] = a1;
        arrA[1] = a2;
        arrA[2] = a3;
    }

    public T getA(int i){
        return arrA[i];
    }

    public void setA(T a, int i){
        arrA[i] = a;
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Holder<A> var = new Holder<>(new A(), new A(), new A());
        System.out.println(var.getA(0));
        System.out.println(var.getA(1));
        System.out.println(var.getA(2));
    }
}
