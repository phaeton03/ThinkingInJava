package ThinkingInJava.Generics.P504;

interface A{
    void a();
}
interface B{
    void b();
}

public class BoundedTagClass implements A,B{
    @Override
    public void a() {
        System.out.println("Interface A method a() - BoundeTagClass.a()");
    }

    @Override
    public void b() {
        System.out.println("Interface B method b() - BoundeTagClass.b()");
    }

    public static <T extends A> void showA(T arg){ arg.a(); }
    public static <T extends B> void showB(T arg){ arg.b(); }

    public static void main(String[] args) {
        BoundedTagClass bdc = new BoundedTagClass();
        showA(bdc);
        showB(bdc);
    }
}
