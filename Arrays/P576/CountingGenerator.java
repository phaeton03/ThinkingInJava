package ThinkingInJava.Arrays.P576;

import ThinkingInJava.Generics.P471.Generator;

public class CountingGenerator{
    public static class Berilium implements Generator<ThinkingInJava.Arrays.P576.Berilium> {
        @Override
        public ThinkingInJava.Arrays.P576.Berilium next() {
            return new ThinkingInJava.Arrays.P576.Berilium();
        }
    }
    public static class BigInteger implements Generator<java.math.BigInteger>{
        private java.math.BigInteger value = java.math.BigInteger.ZERO;
        @Override
        public java.math.BigInteger next() {
            value = value.add(java.math.BigInteger.ONE);
        return value;
        }
    }
    public static class Double implements Generator<java.lang.Double>{
        public Double(double value) {
            this.value = value;
        }
        public Double(){}
        private double value = 0.0;
        @Override
        public java.lang.Double next() {
            double result = value;
            value+= 1.0;
            return result;
        }
    }
    public static class Integer implements Generator<java.lang.Integer>{
        private int value = 0;
        public Integer(){}
        public Integer(int value) {
            this.value = value;
        }
        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }
    public static class Character implements Generator<java.lang.Character>{
        char[] chars = ("qwertyuiopasdfghjklzxcvbnm" +
                "qwertyuiopasdfghjklzxcvbnm".toUpperCase()).toCharArray();
        int index = 0;
        @Override
        public java.lang.Character next() {
            int next = index++ % chars.length;
            return chars[next];
        }
    }

    public static class String implements Generator<java.lang.String>{
        private Character charGen = new Character();
        private int size = 7;
        public String(){}
        public String(int size) {
            this.size = size;
        }
        @Override
        public java.lang.String next() {
            char[] charr = new char[size];
            for (int i = 0; i < size; i++)
                charr[i] = charGen.next();
            return new java.lang.String(charr);
        }
    }
}
