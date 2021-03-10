package ThinkingInJava.IO.P717;

/**
 * Created by Home on 03.09.2020.
 */
//Exercise 25: (6) Experiment with changing the ByteBuffer.allocate( )
// statements in the examples in this chapter to ByteBuffer.allocateDirect( ).
// Demonstrate performance differences, but also notice whether the startup time
// of the programs noticeably changes.
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class ByteBufferPerfomance {
    private static int numOfInts = 140000000;
    private static int numOfUbuffInts = 200000;
    private static final int BSIZE = numOfInts * 5;
    private abstract static class Tester {
        private String name;
        public Tester(String name) {
            this.name = name;
        }
        public void runTest() {
            System.out.println(name +": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration/1.0e9);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        public abstract void test() throws IOException;
    }
    private static Tester[] tests = { new Tester("Write ByteBuffer.allocate()") {
        @Override
        public void test() throws IOException {
            FileChannel out = new FileOutputStream("temp.txt").getChannel();
            ByteBuffer bb = ByteBuffer.allocate(BSIZE);
            IntBuffer ib = bb.asIntBuffer();
            for(int i = 0; i < numOfInts; i++) {
                ib.put(i);
            }
            out.write(bb);
            out.close();
        }
    },
    new Tester("Read ByteBuffer.allocate") {
        @Override
        public void test() throws IOException {
            FileChannel in = new FileInputStream("temp.txt").getChannel();
            ByteBuffer bb = ByteBuffer.allocate(BSIZE);
            in.read(bb);
            for(int i = 0; i < numOfInts; i++)
                bb.get(i);
            in.close();
        }
    },
    new Tester("Write ByteBuffer.allocateDirect()") {
        @Override
        public void test() throws IOException {
            FileChannel out = new FileOutputStream("temp2.txt").getChannel();
            ByteBuffer bb = ByteBuffer.allocateDirect(BSIZE);
            IntBuffer ib = bb.asIntBuffer();
            for(int i = 0; i < numOfInts; i++) {
                ib.put(i);
            }
            out.write(bb);
            out.close();
        }
    },
      new Tester("Read ByteBuffer.allocateDirect()") {
        @Override
        public void test() throws IOException {
            FileChannel in = new FileInputStream("temp2.txt").getChannel();
            ByteBuffer bb = ByteBuffer.allocateDirect(BSIZE);
            in.read(bb);
            for(int i = 0; i < numOfInts; i++)
                bb.get(i);
            in.close();
        }
    }};

    public static void main(String[] args) {
        for(Tester test : tests)
            test.runTest();
    }
}
