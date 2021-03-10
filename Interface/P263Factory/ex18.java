package ThinkingInJava.Interface.P263Factory;

public class ex18 {
    public static void rideCircle(CircleFactory circleFactory){
        Circle circle = circleFactory.getCircle();
        circle.ride();
    }

    public static void main(String[] args) {
        rideCircle(new CircleFactory1());
        System.out.println();
        rideCircle(new CircleFactory2());
        System.out.println();
        rideCircle(new CircleFactory3());
    }
}
