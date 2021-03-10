package ThinkingInJava.Arrays.P576;

import ThinkingInJava.Generics.P471.Generator;
import java.util.*;
public class RandomGenerator {
    public static class RandomInteger implements Generator<Integer> {
        private static Random random = new Random(47);
        private int bound = 100;
        public RandomInteger(){}
        public RandomInteger(int bound) { this.bound = bound; }
        @Override
        public Integer next() {
            return random.nextInt(bound);
        }
    }
    public static class RandomChar implements Generator<Character>{
        private static Random random = new Random(47);
        char[] chars = ("qwertyuiopasdfghjklzxcvbnm" +
                "qwertyuiopasdfghjklzxcvbnm".toUpperCase()).toCharArray();
        @Override
        public Character next() {
            return chars[random.nextInt(chars.length - 1)];
        }
    }
    public static class RandomString implements Generator<String>{
        private static Random random = new Random(47);
        private  RandomChar charGen = new RandomChar();
        private int size = 7;
        public RandomString(){}
        public RandomString(int size) {
            this.size = size;
        }
        @Override
        public String next() {
            char[] charr = new char[size];
            for (int i = 0; i < size; i++)
                charr[i] = charGen.next();
            return new String(charr);
        }
    }
}
