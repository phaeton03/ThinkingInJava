package ThinkingInJava.Interface.P263Factory;

public class ex19 {
    public static void toToss(TossFactory tf){
        CanToss chance = tf.getToss();
        chance.toss();
    }

    public static void main(String[] args) {
        toToss(new DiceFactory());
        toToss(new CoinFactory());
    }
}
