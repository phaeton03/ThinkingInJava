package ThinkingInJava.Arrays.P576;

import ThinkingInJava.Generics.P471.Generator;

import java.lang.reflect.Array;

public class FillArray{
    public static<T> T[] fillArray(Class<T> type, Generator<T> gen, int size){
        T[] arr =(T[]) Array.newInstance(type, size);
        for (int i = 0; i < size; i++)
            arr[i] = gen.next();
        return arr;
    }
}
