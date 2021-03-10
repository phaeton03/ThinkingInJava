package ThinkingInJava.IO.P717;
//Exercise 26: (3) Modify strings/JGrep.java to use Java nio memorymapped files.
import ThinkingInJava.Util.TextFile;

import java.nio.*;
import java.util.regex.*;
public class JGrep {
    public static void searchMathes(String regex, String text) {
        Pattern p = Pattern.compile(regex);
        int index = 0;
        Matcher m = p.matcher("");
        for(String line : new TextFile(text, "\n", true)) {
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
        }
    }
    public static void main(String[] args) {
        searchMathes("a", "Temp.txt");
    }
}
