package ThinkingInJava.IO.P731;
//Exercise 29: (2) In Blip3.java, comment out
// the two lines after the phrases "You must do this:"
// and run the program. Explain the result and why
// it differs from when the two lines are in the program.

import java.io.*;

public class Blip3 implements Externalizable {
    private int i;
    private String s;
    public Blip3() {
        System.out.println("Blip3 Constructor");
    }
    public Blip3(String x, int i) {
        this.i = i;
        s = x;
    }

    @Override
    public String toString() { return s + " " + i; }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
      //  out.writeObject(s);
      //  out.writeInt(i);
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        System.out.println("Blip3.readExternal");
     //   s = (String) in.readObject();
       // i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing Objects: ");
        Blip3 b3 = new Blip3("A String", 47);
        System.out.println(b3);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving object:");
        out.writeObject(b3);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering b3:");
        b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }
}
