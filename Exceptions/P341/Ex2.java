package ThinkingInJava.Exceptions.P341;
class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
    public void display(){
        System.out.println(getMessage());
    }
}

class  MyRunException extends RuntimeException{}

public class Ex2 {
    public  static void f() throws MyRunException{};
    public static void main(String[] args) {
        try{
            throw new MyException("MyException1");
        }catch(MyException e){
            e.display();
            System.err.println(e);
            throw new RuntimeException();
        }

    }
}
