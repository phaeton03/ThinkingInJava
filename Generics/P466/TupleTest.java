package ThinkingInJava.Generics.P466;
class Automobile{}

class Ship{}

public class TupleTest {
    public static void main(String[] args) {
        SixTuple sixTuple = new SixTuple("Solid", 45, 45.0, new Automobile(), new Plane(), new Ship());
        System.out.println(sixTuple);
    }
}
