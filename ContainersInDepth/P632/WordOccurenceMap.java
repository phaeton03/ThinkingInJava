package ThinkingInJava.ContainersInDepth.P632;

import ThinkingInJava.ContainersInDepth.P621.AssociativeArray;

public class WordOccurenceMap {
    public static SlowMap<String, Integer> wordCounter(String text){
        String[] words = text.split("\\W+");
        SlowMap<String, Integer> result = new SlowMap<>();
        for (String word : words)
            if (result.get(word) == null) result.put(word, 1);
            else result.put(word, result.get(word) + 1);
        return result;
    }
}
