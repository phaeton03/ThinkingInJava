package Generics.P317;
import java.util.*;
public class Vowels {

    private static Set<String> vowelSet = new HashSet<>(Arrays.asList("A E I O U Y a e i o u y".split(" ")));
    public static Map<String, Integer> countVowels(String words){
        String vowels = "AEIOUY";
        Map<String,Integer> listCount = new LinkedHashMap<>();
        Set<String> setWords = new LinkedHashSet<>(Arrays.asList(words.trim().split(" ")));
            Integer count = 0;
            for (Character ch : words.toCharArray())
                if (vowels.contains(ch.toString()) || vowels.toLowerCase().contains(ch.toString()))
                for (String v : vowelSet)
                    if (v.equals(ch.toString())){ //count++;
                        count = listCount.get(v) == null ? 1 : listCount.get(v) + 1;
                        listCount.put(v,count);
                    break;}
        int sum = 0;
        for (Integer i : listCount.values())
            sum += i;
        listCount.put("total", sum);
        //System.out.println(setWords);
        return listCount;
    }
    public static void main(String[] args) {
        String words = "Hello My name is Nickolay";
        System.out.println(countVowels(words));
    }
}
