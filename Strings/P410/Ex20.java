package ThinkingInJava.Strings.P410;

import java.util.Scanner;

//import net.mindview.util.*;
public class Ex20 {
    String s;
    int a ;
    long b ;
    float c;
    double d;

    public Ex20(String s) {
        Scanner scanner = new Scanner(s);
        this.s = scanner.next();
        a = scanner.nextInt();
        b = scanner.nextLong();
        c = scanner.nextFloat();
        d = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return s + " a = " + a + " b = " + b + " c = " + c + " d = " + d;
    }

    public static void main(String[] args) {
        System.out.println(new Ex20("hello 99 999 99.8 99.989"));
    }
}
