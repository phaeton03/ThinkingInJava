package ThinkingInJava.IO.P696;

import java.util.*;
import java.io.*;

//Exercise 17: (4) Using TextFile and a Map<Character,Integer>,
// create a program that counts the occurrence of all the different
// characters in a file. (So if there are 12 occurrences of the
// letter ‘a’ in the file, the Integer associated with the Character containing ‘a’ in the Map contains ‘12’).

public class CharacterFileCounter {
    public static File file = new File("Events.txt");
    public static Map<Character, Integer> charMap(File file) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String s;
            while((s = reader.readLine()) != null) {
                for(char ch : s.toCharArray()) {
                    int countChar = hashMap.get(ch) == null ? 1 : hashMap.get(ch) + 1;
                    hashMap.put(ch, countChar);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return hashMap;
    }

    public static void main(String[] args) {
        System.out.println(charMap(file));
    }
}
