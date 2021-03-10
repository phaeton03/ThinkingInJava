package ThinkingInJava.ContainersInDepth.P639;

//Exercise 26: (2) Add a char field to
// CountedString that is also initialized in
// the constructor, and modify the hashCode( )
// and equals( ) methods to include the value of this char.
import java.util.*;
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    private char symb = '\0';
    public CountedString(String str){
        Random random = new Random();
        s = str;
        this.symb = (char) random.nextInt(1000);
        created.add(s);
        for(String s2 : created)
            if(s2.equals(s))
                id++;
    }
    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " char: " + symb + " hashCode(): " + hashCode();
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        result = 37 * result + (int)symb;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CountedString && s.equals(((CountedString)o).s)
                && id == ((CountedString)o).id && symb == ((CountedString)o).symb;
    }

    public static void main(String[] args) {
        char symb = (char) new Random().nextInt(1000);
        System.out.println(symb);
    }
}
