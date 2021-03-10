package ThinkingInJava.Interface.P263Factory;

public class CircleFactory3 implements CircleFactory {
    @Override
    public Circle getCircle() {
        return new Tricycle();
    }
}
