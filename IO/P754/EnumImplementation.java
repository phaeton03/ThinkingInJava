package ThinkingInJava.IO.P754;

//Exercise 2: (2) Instead of implementing an interface,
// make next( ) a static method. What are the benefits and drawbacks of this approach?

import ThinkingInJava.Generics.P471.Generator;
import java.util.*;

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random rand = new Random(47);
    public static CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}
public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
       // CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i = 0; i < 7; i++)
            System.out.println(CartoonCharacter.next());
    }
}
