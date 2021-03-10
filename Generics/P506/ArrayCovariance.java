package ThinkingInJava.Generics.P506;
import java.util.*;
class A{}
class B extends A{}

public class ArrayCovariance {

    public static void fill(Number[] array){
        Random random = new Random();
        for(int i = 0; i < array.length; i++)
            array[i] = random.nextInt(array.length*10);
    }
    public static void main(String[] args) {
        Number[] number = new Integer[10];
        number[3] = Integer.valueOf(10);
        List<? extends Number> listExtNum = Arrays.asList(10.0,8.8);
        System.out.println(listExtNum);
        ArrayList<? super Integer> listSupNum = new ArrayList<Number>();
        Number n = 10;
        }
    }

