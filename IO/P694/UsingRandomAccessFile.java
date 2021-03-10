package ThinkingInJava.IO.P694;

import java.io.*;

public class UsingRandomAccessFile {
    static String file = "DATA2.txt";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        rf.readBoolean();
        rf.readByte();
        rf.readChar();
        rf.readDouble();
        rf.readFloat();
        rf.readInt();
        rf.readLong();
        rf.readShort();
        rf.readUTF();
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeBoolean(false);
        rf.writeByte(1502);
    }
}
