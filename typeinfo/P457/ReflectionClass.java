package ThinkingInJava.typeinfo.P457;

import java.lang.reflect.*;

class Test{
    int num = 9;
    private String str = "Stroka";
    void f(){
        System.out.println("Package f()");
    }
    private void g(){
        System.out.println("Private g()");
    }
    protected void u(){
        System.out.println("Protected u()");
    }
}
public class ReflectionClass {
    public static void callHiddenMethod(Object obj, String nameMethod) throws Exception{
        Method m = obj.getClass().getDeclaredMethod(nameMethod);
        m.setAccessible(true);
        m.invoke(obj);
    }
    public static void main(String[] args) throws Exception{
        Test test = new Test();
        callHiddenMethod(test, "g");
        callHiddenMethod(test, "f");
        callHiddenMethod(test, "u");
        Field f = test.getClass().getDeclaredField("num");
        f.setAccessible(true);
        int num = f.getInt(test);
        System.out.println(num);
        f.setInt(test, 90);
        System.out.println(f.getInt(test));
        Field f2 = test.getClass().getDeclaredField("str");
        f2.setAccessible(true);
        String stroka = (String) f2.get(test);
        System.out.println(stroka);
        f2.set(test,"probel");
        stroka = (String) f2.get(test);
        System.out.println(stroka);

    }
}
