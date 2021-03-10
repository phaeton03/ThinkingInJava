package ThinkingInJava.IO.P706;
//Exercise 23: (6) Create and test a utility
// method to print the contents of a CharBuffer
// up to the point where the characters are no longer printable.
import ThinkingInJava.Arrays.P576.CountingGenerator;

import java.nio.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class CharBuferPP {
    private static final int BSIZE = 1024;
    public static void printCharByOneByte(String input) throws IOException {
        FileChannel in = new FileInputStream(input).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        in.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char) buff.get());
        in.close();
    }
    public static void printCharBuffer(String input) throws IOException{
        FileChannel in = new FileInputStream(input).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        in.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        //buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoding using : " + encoding + "\n" + Charset.forName(encoding).decode(buff));
    }

    public static void main(String[] args) {
        try {
            printCharByOneByte("Events.txt");
            System.out.println("\n=================print asCharBuffer======================");
            printCharBuffer("Events.txt");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
