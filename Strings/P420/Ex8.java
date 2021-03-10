package ThinkingInJava.Strings.P420;

import java.lang.reflect.Field;

class Test{
    String test = "test";

}

public class Ex8 extends Test{
    String str = "gg";
    int num = 0;
    public static void printClasses(Class type){
        try{
            System.out.println("\"Full name of class\" - " + type.getName());
            Field [] fields = type.getDeclaredFields();
            if (fields.length != 0)
                for (Field field : fields)
                    System.out.println("\"Field :\" " + field);
            printClasses(type.getSuperclass());
        }catch(Exception e){
            System.err.println(e);
        }
    /*    if (type == null ) {
            return;
        }else{
            System.out.println(type.getName());
           // System.out.println(obj.getClass().getSuperclass().getName());
           printClasses(type.getSuperclass());*/
        }
    //}
    public static void main(String[] args) {
        Ex8 ex8 = new Ex8();
        printClasses(ex8.getClass());
    }
}
