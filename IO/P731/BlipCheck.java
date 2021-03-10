package ThinkingInJava.IO.P731;

import java.io.*;

//Exercise 28 : (2) In BlipCheck.java, copy the file and
// rename it to BlipCheck.java and rename the class
// Blip2 to BlipCheck (making it public and removing
// the public scope from the class Blips in the process).
// Remove the //! marks in the file and execute the
//program, including the offending lines. Next, comment
// out the default constructor for BlipCheck. Run it and
// explain why it works. Note that after compiling, you
// must execute the program with "Java Blips" because
// the main( ) method is still in the class Blips.
class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 Constructor");
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

public class BlipCheck implements Externalizable {
   //  BlipCheck() { System.out.println("Blip2 constructor"); }
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}
class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        BlipCheck bc = new BlipCheck();
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("saving objects");
        ous.writeObject(b1);
        ous.writeObject(bc);
        ous.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("recovering b1:");
        b1 = (Blip1) ois.readObject();
        System.out.println("recovering b2");
        bc = (BlipCheck) ois.readObject();
    }
}
