package ThinkingInJava.Exceptions.P352;

class MyException1 extends Exception{}
class MyException2 extends Exception{}
public class Ex10 {
    public static void g() throws MyException1{
        throw new MyException1();
    }
    public static void f() {
        try{
        g();
        }catch(MyException1 e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        f();
    }
}
