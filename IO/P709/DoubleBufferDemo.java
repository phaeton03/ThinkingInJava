package ThinkingInJava.IO.P709;
//Exercise 24: (1) Modify IntBufferDemo.java to use doubles
import java.nio.*;

public class DoubleBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        db.put(new double[]{ 1.4, 44.3, 32.3, 99.09, 95.78 });
        System.out.println(db.get(3));
        db.put(3,77.777);
        db.flip();
        while(db.hasRemaining()) {
            double d = db.get();
            System.out.println(d);
        }
    }
}
