package ThinkingInJava.Interface.P263Factory;

public class CircleFactory1 implements CircleFactory {
    @Override
    public Circle getCircle() {
        return new Unicycle();
    }
}
