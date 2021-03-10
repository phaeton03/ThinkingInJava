package ThinkingInJava.Util;

// Static functions for reading and writing text files as
// a single string, and treating a file as an ArrayList.

import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

public class TextFile extends ArrayList<String> {
    static int length = 0x8FFFFFF;
    // Read a file as a single string:
    public static String read(String fileName, boolean setMapping) {
        if(setMapping == false) return read(fileName);
        StringBuilder sb = new StringBuilder();
        try {
            MappedByteBuffer in =
                    new RandomAccessFile(new File(fileName), "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
            String encoding = System.getProperty("file.encoding");
            CharBuffer cb = Charset.forName(encoding).decode(in);
            while (cb.hasRemaining())
                sb.append(cb.get());
        } catch (IOException e) {
            System.err.println(e);
        }
        return sb.toString();
    }
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    public static void write(String fileName, String text, boolean setMapping) {
        if(setMapping == false) {
            write(fileName, text);
            return;
        }
        try {
            MappedByteBuffer out =
                    new FileOutputStream(fileName).getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
            CharBuffer cb = out.asCharBuffer();
            cb.put(text);
        } catch(IOException e) {
            System.err.println(e);
        }
    }
    // Write a single file in one method call:
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Read a file, split by any regular expression:

    public TextFile(String fileName, String splitter, boolean setMapping) {
        super(Arrays.asList(read(fileName, setMapping).split(splitter)));
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if(get(0).equals("")) remove(0);
    }
    // Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for(String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Simple test:
    public static void main(String[] args) {
        String file = read("src\\ThinkingInJava\\Util\\TextFile.java");
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        System.out.println(new File("test2.txt").getAbsoluteFile());
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(
                new TextFile("src\\ThinkingInJava\\Util\\TextFile.java", "\\W+"));
        // Display the capitalized words:
        System.out.println(words.headSet("a"));
    }
}