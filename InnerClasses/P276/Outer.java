package ThinkingInJava.InnerClasses.P276;

public class Outer {
    public void change(){}

    public static void main(String[] args) {
        Ex12 ex12 = new Ex12();
        Outer outer = ex12.outer(990);
        outer.change();

    }
}
