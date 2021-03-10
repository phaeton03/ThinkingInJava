package ThinkingInJava.Containers.P319;
import java.util.*;

public class Ex21 {
    public static Map<String, Integer> numberOfWords(String text){
        HashMap<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (String s : text.split("\\W+")){
            Integer freq = hashMap.get(s);
            hashMap.put(s, freq == null ? 1 : freq + 1);
        }
        Set<String> keySet = hashMap.keySet();
        ArrayList<String> keys = new ArrayList(keySet);
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (String s : keys){
            linkedHashMap.put(s, hashMap.get(s));
        }
        return linkedHashMap;
    }
    public static void main(String[] args) {
        String manyWords = "Text is normal. His name is John Marston. He is 35 years old. He will be good";
        System.out.println(numberOfWords(manyWords));
    }
}
