package ThinkingInJava.Generics.P506;
import java.util.*;

public class ListCovariance {
    public static void main(String[] args) {
        List<Integer> listI = new ArrayList<>();
        List<? extends Number> listN = new ArrayList<>();
        for (Integer i = 0; i < 10; i++)
       //     listN.add(i);
        System.out.println(listN);
    }
}
