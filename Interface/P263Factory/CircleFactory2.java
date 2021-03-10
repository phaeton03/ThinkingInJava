package ThinkingInJava.Interface.P263Factory;


public class CircleFactory2 implements CircleFactory {
    @Override
    public Circle getCircle() {
        return new Bicycle();
    }
}
