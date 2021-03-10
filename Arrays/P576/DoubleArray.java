package ThinkingInJava.Arrays.P576;

import ThinkingInJava.Generics.P471.Generator;
import java.util.*;
import java.lang.reflect.Array;
import java.math.*;

public class DoubleArray {
    public static void main(String[] args) {
        Double[] darr = FillArray.fillArray(Double.class, new CountingGenerator.Double(),10);
        double[] primArrDouble = PrimitiveConverter.convertToDouble(darr);
        System.out.println(darr.getClass().equals(primArrDouble.getClass()));
        System.out.println(Arrays.toString(primArrDouble));
        Character[] charr = FillArray.fillArray(Character.class, new CountingGenerator.Character(), 5);
        System.out.println(Arrays.toString(charr));
        String[] str = FillArray.fillArray(String.class, new CountingGenerator.String(4),5);
        System.out.println(Arrays.toString(str));
        System.out.println(new CountingGenerator.String(6).next());
        BigInteger[] bigIntArr = FillArray.fillArray(BigInteger.class, new CountingGenerator.BigInteger(),5);
        System.out.println(Arrays.toString(bigIntArr));
    }
}
