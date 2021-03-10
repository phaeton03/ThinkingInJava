package ThinkingInJava.Interface.P263Factory;

public class CoinFactory implements TossFactory {
    @Override
    public CanToss getToss() {
        return new Coin();
    }
}
