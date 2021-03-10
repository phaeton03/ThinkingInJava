package ThinkingInJava.IO.P759;

//Exercise 5: (4) Modify control/VowelsAndConsonants.java so
// that it uses three enum types: VOWEL, SOMETIMES_A_VOWEL, and CONSONANT.
// The enum constructor should take the various letters that describe that
// particular category. Hint: Use varargs, and remember that varargs
// automatically creates an array for you.

import ThinkingInJava.Arrays.P576.RandomGenerator;

import java.util.EnumSet;


public enum VowelsAndConsonants {
    VOWELS("aeoui".toCharArray()),
    CONSONANTS("qrtpsdfghjklzxcvbnm".toCharArray()),
    SOMETIMES_A_VOWEL("wy".toCharArray());
    private char[] c;
    private VowelsAndConsonants(char... args) {
        c = args;
    }
    public String getLetters() {
        return new String(c);
    }
    public boolean check(char letter) {
        return getLetters().contains(String.valueOf(letter).toLowerCase());
    }
    @Override
    public String toString() {
        return name() + " " + getLetters();
    }
    public static void main(String[] args) {
        EnumSet<VowelsAndConsonants> numSet = EnumSet.allOf(VowelsAndConsonants.class);
        for(int i = 0; i < 10; i++) {
        char c = new RandomGenerator.RandomChar().next();
        for(VowelsAndConsonants sound : values())
            if(sound.check(c)) System.out.println(c + " : " + sound);
        }
    }
}
