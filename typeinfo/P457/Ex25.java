package ThinkingInJava.typeinfo.P457;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test2{
    private int a = 1;
    String s = "slovo";
    private void f(){
        System.out.println("Private method f()");
    }
    void g(){
        System.out.println("Package method g()");
    }
    protected void h(){
        System.out.println("Protected method h()");
    }
}
public class Ex25 {
    public static void callMethod(Object obj, String method) throws Exception{
        Method g = obj.getClass().getDeclaredMethod(method);
        g.setAccessible(true);
        g.invoke(obj);
    }
    public static void main(String[] args) throws Exception {
        Test2 test = new Test2();
        callMethod(test,"f");
        callMethod(test,"g");
        callMethod(test,"h");
        Field f = test.getClass().getDeclaredField("a");
        f.setAccessible(true);
        int num = f.getInt(test);
        int num2 = (Integer) f.get(test);
        System.out.println(num2);
        System.out.println(f);
        System.out.println(num);
        Field f2 = test.getClass().getDeclaredField("s");
        String s = (String) f2.get(test);
        System.out.println(s);
    }
}
