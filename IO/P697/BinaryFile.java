package ThinkingInJava.IO.P697;
//Exercise 19: (2) Using BinaryFile and a Map<Byte,Integer>,
// create a program that counts the occurrence of all the different bytes in a file.
//====================================================================================
//Exercise 20: (4) Using Directory.walk( ) and BinaryFile, verify that all .class
// files in a directory tree begin with the hex characters ‘CAFEBABE’.
import ThinkingInJava.IO.P676.Directory;

import java.io.*;
import java.util.*;

import static ThinkingInJava.IO.P676.Directory.walk;

public class BinaryFile {
    public static byte[] read(File bFile) throws IOException{
        try(BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile))) {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }
    }
    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
    public static Map<Byte,Integer> byteCounter(File bFile) throws IOException {
        Map<Byte,Integer> map = new HashMap<>();
        byte[] bytes = read(bFile);
        for(byte b : bytes) {
            int count = map.get(b) == null ? 1 : map.get(b) + 1;
            map.put(b, count);
        }
        return map;
    }
    public static boolean isCAFEBABEclass(File file) throws IOException {
        Directory.TreeInfo treeInfo = walk(file,".*\\.class");
        byte b1 = new Integer(0xCA).byteValue();
        byte b2 = new Integer(0xFE).byteValue();
        byte b3 = new Integer(0xBA).byteValue();
        byte b4 = new Integer(0xBE).byteValue();
        byte[] bArr = {b1, b2, b3, b4};
            for(File f : treeInfo.files){
                byte[] bytes = read(f);
                for(int i = 0; i < bArr.length; i++) {
                    System.out.println(bArr[i] + " : " + bytes[i] + " file " + f);
                    if(bArr[i] != bytes[i]) return false; }
            }
        return true;
    }
    public static void main(String[] args) throws IOException {

        File file = new File("src");
        System.out.println(file.getAbsoluteFile());
        System.out.println(isCAFEBABEclass(file));
       // System.out.println(byteCounter(file));
    }
}
