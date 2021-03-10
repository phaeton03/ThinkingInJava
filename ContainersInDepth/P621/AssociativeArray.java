package ThinkingInJava.ContainersInDepth.P621;

//Exercise 13: (4) Use AssociativeArray Java to create a
// wordoccurrence counter, mapping String to Integer.
// Using the net.mindview.util.TextFile utility in this book,
// open a text file and break up the words in that file using
// whitespace and punctuation, and count the occurrence of the words in that file.

import ThinkingInJava.Arrays.P576.CountingGenerator;

import java.util.Arrays;
import java.util.*;

public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private Set<K> keySet;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
        keySet = new HashSet<>();
    }
    private int indexOf(K key){
        for(int i = 0; i < index; i++)
            if(key.equals(pairs[i][0])) return i;
            return -1;
    }
    public void put(K key, V value){
        if ( index > pairs.length) throw new ArrayIndexOutOfBoundsException();
        int pos;
        if(keySet.contains(key)) {
            pos = indexOf(key);
            pairs[pos] = new Object[]{key, value};
        }
        else pairs[index++] = new Object[]{key, value};
        keySet.add(key);
    }
    @SuppressWarnings("unchecked")
    public V get(K key){
        for(int i = 0; i < index; i++)
            if(key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < index; i++){
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if(i < index - 1 )
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s2 = "hello hello /., hello";
        String s = "hello, his name is John. John is a good guy. He has got a cat and a hamster!";
       // System.out.println(WordOccurence.wordCounter(s2));
        System.out.println(WordOccurence.wordCounter(s));
    }
}
