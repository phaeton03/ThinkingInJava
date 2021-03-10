package ThinkingInJava.Generics.P482;

import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Generics.P475.Generators;

import java.util.*;
class SmallFish{
    static long counter = 1;
    final long id = counter++;
    private SmallFish() {}
    public static Generator<SmallFish> generator(){
        return new Generator<SmallFish>() {
            @Override
            public SmallFish next() {
                return new SmallFish();
            }
        };
    }

    @Override
    public String toString() {
        return "SmallFish " + id;
    }
}
class BigFish{
    static long counter = 1;
    final long id = counter++;
    private BigFish() {}
    public static Generator<BigFish> generator = new Generator(){
        @Override
        public BigFish next(){
            return new BigFish();
        }
    };

    @Override
    public String toString() {
        return "BigFish " + id;
    }
}
public class Ocean {
    public static void eat(BigFish bigFish, SmallFish smallFish){
        System.out.println(bigFish + " eat " + smallFish);
    }
    public static void main(String[] args) {
        Random rand = new Random(48);
        ArrayList<SmallFish> prey = new ArrayList<>();
        prey = Generators.fill(prey, SmallFish.generator(),15);
        LinkedList<BigFish> predator = new LinkedList<>();
        predator = Generators.fill(predator, BigFish.generator,5);
        for(SmallFish sf : prey)
            eat(predator.get(rand.nextInt(predator.size())),sf);
    }
}
