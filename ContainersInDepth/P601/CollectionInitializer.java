package ThinkingInJava.ContainersInDepth.P601;

//Exercise 4: (2) Create a Collection initializer
// that opens a file and breaks it into words using TextFile,
// and then uses the words as the source of data for the
// resulting Collection. Demonstrate that it works.

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CollectionInitializer {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Nick\\Desktop\\TXT.txt");
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
        }catch(IOException e){
            System.err.println(e);
        }
        for (String line: list)
            for(String word: line.split("\\s"))
                result.add(word);
        System.out.println(result);
    }
}

