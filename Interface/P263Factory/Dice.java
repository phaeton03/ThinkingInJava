package ThinkingInJava.Interface.P263Factory;

public class Dice implements CanToss {
    @Override
    public void toss() {
        System.out.println((int) (Math.random() * 6 + 1));
    }
}
