package ThinkingInJava.typeinfo.P442;

import java.util.regex.*;
import java.lang.reflect.*;
class ShowMethods2{

}
public class ShowMethods {
    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or: \n" +
            "ShowMethods qualified.class.name word\n"+
            "To search for methods involving 'word";
    private static Pattern p = Pattern.compile("\\w+\\.|\\bfinal\\s|\\bnative\\s");

    public static void main(String[] args) {
        int lines = 0;
        try {
            Class<?> c = Class.forName("ThinkingInJava.typeinfo.P442.ShowMethods2");
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            for (Method method : methods)
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            if(ctors.length !=0 ) System.out.println("Constructor" );
            for (Constructor ctor : ctors)
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            lines = methods.length + ctors.length;
        }catch(ClassNotFoundException e){
            System.err.println("No such class " + e);
        }
    }
}
