package ThinkingInJava.typeinfo.P442;
import java.lang.reflect.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface HasBatteries {
}

interface WaterProof {
}

interface Shoots {
}

class Toy {
    public static final int VAR1 =10;
    private String txt = "Spasibo";
    public void getResult(int i){}
    Toy() {
    }

    Toy(Integer i) {
    }
}

class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    public static void allInfo(Class<?> clazz){
        Pattern p = Pattern.compile("\\w+\\.");
        Constructor<?>[] ctors = clazz.getDeclaredConstructors();
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        for(Constructor<?> ctor : ctors)
            System.out.println(p.matcher(ctor.toString()).replaceAll(""));
        for(Field field : fields)
            System.out.println(p.matcher(field.toString()).replaceAll(""));
        for(Method method : methods)
            System.out.println(p.matcher(method.toString()).replaceAll(""));
    }
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("ThinkingInJava.typeinfo.P442.Toy");
            Class clazz = Integer.class;
            Constructor<?>[] ctor = c.getDeclaredConstructors();
            Toy toy = (Toy) ctor[1].newInstance(10);
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("/----------------------------------------------/");
        ToyTest.allInfo(Toy.class);
    }
}
