package ThinkingInJava.Generics.P494;


import ThinkingInJava.Generics.P484.Port;

import java.util.*;
class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<?>> hashMap = new HashMap<>();
    public void addType(String typename, Class<?> kind){
        hashMap.put(typename, kind);
    }
    public Object createNew(String typename){
        Class<?> cl = hashMap.get(typename);
        try{
            return cl.newInstance();
        } catch(NullPointerException e){
            System.out.println("Not a registered typename: " + typename);
        } catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    public ClassTypeCapture(Class<T> kind) { this.kind = kind; }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        ctt1.addType("Building", Building.class);
        ctt1.addType("House", House.class);
        ctt1.addType("Port", Port.class);
        System.out.println(ctt1.createNew("Building").getClass());
        System.out.println(ctt1.createNew("House").getClass());
        ctt1.createNew("Por");
        ctt1.createNew("Car");
    }
}
