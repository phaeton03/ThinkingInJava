package ThinkingInJava.Interface.P263Factory;

public class DiceFactory implements TossFactory {
    @Override
    public CanToss getToss() {
        return new Dice();
    }
}
