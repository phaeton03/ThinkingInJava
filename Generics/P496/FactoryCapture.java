package ThinkingInJava.Generics.P496;

import java.util.*;
class Building {}
class House extends Building {}

class ClassTypeCapture<T> {
    Map<String, FactoryI<T>> hashMap = new HashMap<>();
    public void addType(String typename, FactoryI<T> kind){
        hashMap.put(typename, kind);
    }
    public Object createNew(String typename){
         return hashMap.get(typename).create(9);
    }
}
public class FactoryCapture {
    public static void main(String[] args) {
        ClassTypeCapture<Integer> ctc = new ClassTypeCapture<>();
        ctc.addType("IntegerFactory", new IntegerFactory());
        System.out.println(ctc.createNew("IntegerFactory"));
        ClassTypeCapture<Widget> ctcW = new ClassTypeCapture<>();
        ctcW.addType("WidgetFactory", new Widget.Factory());
        System.out.println(ctcW.createNew("WidgetFactory"));
    }
}

