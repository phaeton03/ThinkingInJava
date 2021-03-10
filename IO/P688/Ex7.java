package ThinkingInJava.IO.P688;
//Exercise 7: (2) Open a text file so that you can
// read the file one line at a time. Read each
// line as a String and place that String object into a
// LinkedList. Print all of the lines in the LinkedList in reverse order.
//-----------------------------------------
//Exercise 10: (2) Modify Exercise 8 to take additional command-line
// arguments of words to find in the file. Print all lines in which any of the words match.
//----------------------------------------------------------------------------
//Exercise 12: (3) Modify Exercise 8 to also open a text file so you can
// write text into it. Write the lines in the LinkedList, along with
// line numbers (do not attempt to use the "LineNumber" classes), out to the file.
import ThinkingInJava.InnerClasses.P283.B;

import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Ex7 {
    public static List<String> writeFile(File in, File out) {
        LinkedList<String> list = new LinkedList<>();
        int lineCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(in));
            PrintWriter writer = new PrintWriter(out))
        {
          String s;
          while ((s = reader.readLine()) != null){
              writer.println(lineCount++ + ": " + s);
              list.add(lineCount + ": " + s);
          }
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }
    public static<T> void printReverseLL(LinkedList<T> c) {
        ListIterator<T> listIt = c.listIterator(c.size());
        while(listIt.hasPrevious())
        System.out.println(((String)listIt.previous()).toUpperCase());
    }
    public static <T> void printPattern(LinkedList<T> c, String reg) {
        String regex = "(?i).*\\b" + reg +"\\b.*";
        Pattern pattern = Pattern.compile(regex); //".*\b" + reg + "\b.*"
        for(T t : c)
            if(pattern.matcher((String)t).matches())
                System.out.println(t);
    }
    public static void main(String[] args) {
        File file  = new File("test.txt");
        LinkedList<String> list = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null)
                list.add(line);
        } catch (IOException e){
            System.err.println(e);
        }
        printReverseLL(list);
        System.out.println("===================================Pattern========================================");
        printPattern(list,"public");
        System.out.println("===================================Pattern========================================");
        list = (LinkedList<String>) writeFile(new File("Events.txt"), new File("out.txt"));
        for(String s: list)
            System.out.println(s);
    }
}
