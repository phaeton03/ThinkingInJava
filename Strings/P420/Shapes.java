package ThinkingInJava.Strings.P420;

abstract class Shape{
    protected static boolean flagSq = false;
    protected static boolean flagTr = false;
    protected static boolean flagC = false;
    abstract void flagIn();

    void draw(){
        System.out.println(this);
    }

    abstract public String toString();
}

class Square extends Shape{
    private static boolean flag = false;
    void flagIn(){
        flag = true;
    }
    @Override
    public String toString() {
        return "Square\n is highlighted?" + flag;
    }
}

class Triangle extends Shape{
    private static boolean flag = false;
    @Override
    void flagIn() {
        flag = true;
    }

    @Override
    public String toString() {
        return "Triangle\nis highlighted ? - " + flag;
    }
}

class Circle extends Shape{
    private static boolean flag = false;
    @Override
    void flagIn() {
        flag = true;
    }
    @Override
    public String toString() {
        return "Circle\nis highlighted? -" + flag;
    }
}
public class Shapes {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        triangle.flagIn();
        System.out.println(triangle);
    }
}
