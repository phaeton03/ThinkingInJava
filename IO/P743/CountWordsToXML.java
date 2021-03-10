package ThinkingInJava.IO.P743;

import ThinkingInJava.Util.TextFile;
import java.util.*;
import java.io.*;
import nu.xom.*;
//Exercise 32: (4) Using a Map<String,Integer> and the
// net.mindview.util.TextFile utility, write a program
// that counts the occurrence of words in a file (use "\\W+"
// as the second argument to the TextFile constructor). Store the results as an XML file.

public class CountWordsToXML {
    static Map<String,Integer> counterWords;
    public static void wordCounter(String filename) {
        TextFile tf = new TextFile(filename,"\\W+");
        Map<String, Integer> words = new HashMap<>();
        for(String str : tf) {
            int count = words.get(str) == null ? 1 : words.get(str) + 1;
            words.put(str, count);
        }
        counterWords = words;
    }
    public static Element wordCounterToXML(String filename) {
        wordCounter(filename);
        Element root = new Element("words");
        int i = 0;
        for(String str : counterWords.keySet()) {
            Element element = new Element("Number_" + i++);
            Element word = new Element("word_"+str);
            Element count = new Element("freq_" + counterWords.get(str));
            element.appendChild(word);
            element.appendChild(count);
            root.appendChild(element);
        }
        return root;
    }
    public static void format(OutputStream os, Document doc) throws Exception {
        Serializer serializer = new Serializer(os);
        serializer.setIndent(9);
        serializer.setMaxLength(55);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        Element element = wordCounterToXML("test.txt");
        format(System.out, new Document(element));
    }
}
