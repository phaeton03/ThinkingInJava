package Strings.P394;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex7 {
    public static void main(String[] args) {
        String s = "My name is John.";
        String s1 = "my name is John.";
        String s2 = "My name is John";
        String regax = "\\p{javaUpperCase}.*\\.";
        System.out.println(s2.matches(regax));
        Pattern pattern = Pattern.compile(regax);
        Matcher m = pattern.matcher(s);
        System.out.println(m.matches());
    }
}
