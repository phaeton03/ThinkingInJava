package ThinkingInJava.Interface.P263Factory;

import java.util.Random;

public class Coin implements CanToss {
    Random rand = new Random();
    @Override
    public void toss() {
        String rez = Math.random() >= 0.5 ? "Орел" : "Решко" ;
        System.out.println(rez);
        System.out.println(rand.nextInt(5));
    }
}
