package ThinkingInJava.IO.P698;

//Exercise 21: (1) Write a program that takes standard input and
// capitalizes all characters, then puts the results on standard output.
// Redirect the contents of a file into this program (the process of redirection
// will vary depending on your operating system).
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader sdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = sdin.readLine().toUpperCase()) != null && s.length() != 0)
            System.out.println(s);
    }
}
