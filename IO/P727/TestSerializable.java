package ThinkingInJava.IO.P727;
//Exercise 27: (1) Create a Serializable class containing
// a reference to an object of a second Serializable class.
// Create an instance of your class, serialize it to disk,
// then restore it and verify that the process worked correctly.
import java.io.*;
import java.util.*;

class Data implements Serializable{
    Random random = new Random(47);
    private int i;
    public Data() { }
    public Data(int i) {
        this.i = i;
    }
    @Override
    public String toString() {
        return Data.class.getSimpleName() + " i: " + i;
    }
    class Worm implements Serializable{
        private char c;
        private Data next;
        public Worm(int i) {
            if(--i > 0)
            this.next = new Data(i);
            c = 'x' + 1;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(c);
            sb.append(": (");
            sb.append(next);
            sb.append(")");
            return sb.toString();
        }
    }
}
public class TestSerializable {
    public static void main(String[] args) {
        Data.Worm w = new Data().new Worm(4);
        System.out.println("worm = " + w);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"))) {
            out.writeInt(10);
            out.writeUTF("Worm storage\n");
            out.writeObject(w);
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"))) {
                int i = in.readInt();
                String s = in.readUTF();
                Data.Worm w2 = (Data.Worm) in.readObject();
                System.out.println("String = " + s + "int = " + i + " w2 = " + w2);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
