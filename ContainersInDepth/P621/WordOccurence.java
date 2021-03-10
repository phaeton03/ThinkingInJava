package ThinkingInJava.ContainersInDepth.P621;

import ThinkingInJava.ContainersInDepth.P634.SimpleHashMap;
import ThinkingInJava.ContainersInDepth.P634.SimpleHashMap2;

import java.util.Arrays;
import java.util.*;

public class WordOccurence {
     public static AssociativeArray<String, Integer> wordCounter(String text){
         String[] words = text.split("\\W+");
         AssociativeArray<String, Integer> result = new AssociativeArray<>(words.length);
             for (String word : words)
                     if (result.get(word) == null) result.put(word, 1);
                     else result.put(word, result.get(word) + 1);
             return result;
     }
     public static SimpleHashMap<String, Integer> wordCounter2(String text){
         String[] words = text.split("\\W+");
         SimpleHashMap<String,Integer> result = new SimpleHashMap<>();
         for (String word : words)
             if (result.get(word) == null) result.put(word, 1);
             else result.put(word, result.get(word) + 1);
         return result;
     }

    public static SimpleHashMap2<String, Integer> wordCounter3(String text){
        String[] words = text.split("\\W+");
        SimpleHashMap2<String,Integer> result = new SimpleHashMap2<>();
        for (String word : words)
            if (result.get(word) == null) result.put(word, 1);
            else result.put(word, result.get(word) + 1);
        return result;
    }
}


