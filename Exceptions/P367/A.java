package ThinkingInJava.Exceptions.P367;
class OneException extends Exception{}
class TwoException extends OneException{}
class ThreeException extends TwoException{}
public class A {
    public void f() throws OneException{
        throw new OneException();
    }

    public static void main(String[] args) {
        A c = new C();
        try{
            c.f();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

class B extends A{
    @Override
    public void f() throws TwoException {
        throw new TwoException();
    }
}

class C extends B{
    @Override
    public void f() throws ThreeException {
        throw new ThreeException();
    }
}
