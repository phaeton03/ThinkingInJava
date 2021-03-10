package ThinkingInJava.Generics.P488;

interface TypeInterface{
    void f();
    void g();
}
class TypeTest implements TypeInterface{
    @Override
    public void f() { System.out.println("TypeTest.f()"); }
    @Override
    public void g() { System.out.println("TypeTest.g()"); }

    public void h(){
        System.out.println("TypeTest.h()");
    }
}
public class TypeErasure {
    public static <T extends TypeInterface> void genericMethod(T t){
        t.f();
        t.g();
    }

    public static void main(String[] args) {
        genericMethod(new TypeTest());
    }
}
