package ThinkingInJava.IO.P691;

import java.io.*;

public class BasicFileOutput {
    static String file = "out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
     //   LineNumberReader in2 = new BufferedReader(new FileReader(file));
        PrintWriter out = new PrintWriter("out2.txt");
    }
}
