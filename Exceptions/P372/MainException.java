 package ThinkingInJava.Exceptions.P372;

import java.io.*;
public class MainException {
    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("MainException.java");
        in.close();
    }
}
