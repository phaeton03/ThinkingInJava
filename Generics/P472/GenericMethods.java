package ThinkingInJava.Generics.P472;

public class GenericMethods {
    public <T,U> void f(T x, U y, Integer z){
        System.out.println(x.getClass().getName() +
                "\n" + y.getClass().getName() +
                "\n" + z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(10,"Stroka",1);
        gm.f(10.0,9.5f,1);
    }
}
