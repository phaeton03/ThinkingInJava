package ThinkingInJava.IO.P692;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) {
        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("DATA.txt")))) {
            out.writeBoolean(true);
            out.writeByte(10);
            out.writeChar('c');
            out.writeChar('c');
            out.writeDouble(12.01);
            out.writeFloat(20f);
            out.writeInt(10);
            out.writeLong(100l);
            out.writeShort(4);
            out.writeUTF("Strong");
        } catch (IOException e) {
            System.err.println(e);
        }
        try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("DATA.txt")))) {
            System.out.println(in.readBoolean());
            System.out.println(in.readByte());
            System.out.println(in.readChar());
            System.out.println(in.readDouble());
            System.out.println(in.readFloat());
            System.out.println(in.readInt());
            System.out.println(in.readLong());
            System.out.println(in.readShort());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
