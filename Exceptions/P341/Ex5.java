package ThinkingInJava.Exceptions.P341;

import java.util.Random;

public class Ex5 {
    public static void main(String[] args) {
        boolean t = true;
        int[] a = {0,20,40};
        int[] b = {5,0,4};
        Random random = new Random();
        while (t){
            try{
                int num1 = a[random.nextInt(a.length)];
                int num2 = b[random.nextInt(b.length)];
                System.out.println("num1 " + num1 + " num2 " + num2);
                int res = num1 / num2;
                t = false;
                System.out.println("num1 " + num1 + " num2 " + num2 +" res " + res);
            }catch(Exception e){
                System.err.println(e);
            }
        }
    }
}
