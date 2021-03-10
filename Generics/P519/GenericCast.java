package ThinkingInJava.Generics.P519;

import java.util.*;

class FixedSizeStack<T>{
   private int index = 0;
   private List<T> storage = new ArrayList<>();
    public void push(T item){ storage.add(item); index++; }
    public T pop(){
        return storage.get(--index); }
    public void display(){
        System.out.println(storage);
    }
}
public class GenericCast {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>();
        for (int i = 0; i < SIZE; i++)
            strings.push(i + " ");
        for (int i = 0; i < 12; i++)
            System.out.println(strings.pop());

    }
}
