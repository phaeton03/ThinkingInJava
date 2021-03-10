package ThinkingInJava.Generics.P477;

import ThinkingInJava.Generics.P471.Generator;

import java.util.*;

class CounterClass{
    private static int counter = 1;
    private final int count = counter++;

    @Override
    public String toString() {
        return "The instance of " + getClass().getSimpleName() + " " + count;
    }
}
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type) { this.type = type; }
    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Generator<CounterClass> basGen = new BasicGenerator<>(CounterClass.class);
        for (int i = 0; i < 5; i++)
            System.out.println(basGen.next());
    }
}
