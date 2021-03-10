package ThinkingInJava.IO.P740;

import java.io.*;
import java.util.*;
public class CADStateRecovery {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        Circle.deserializeStaticState(in);
        Square.deserializeStaticState(in);
        Line.deserializeStaticState(in);
        System.out.println((List)in.readObject());
    }
}
