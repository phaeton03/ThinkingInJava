package ThinkingInJava.Generics.P543;

import ThinkingInJava.typeinfo.P435.*;

import java.util.*;
import java.lang.reflect.*;

public class Apply {
    public static <T, S extends Iterable<? extends T>>
    void apply(S seq, Method f, Object... args){
        try{
            for (T t: seq)
                f.invoke(t, args);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

class Shape{
    public void rotate() { System.out.println(this + " rotate"); }
    public void resize(int newSize){
        System.out.println(this + " resize " + newSize);
    }
}

class Square extends Shape{}

class FilledList<T> extends ArrayList<T>{
    public FilledList(Class<? extends T> type, int size){
        try{
            for (int i = 0; i < size; i++)
                add(type.newInstance());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
class ApplyTest{
    public static void main(String[] args) throws Exception {
      PetCreator pc = new FactoryPetCreator();
      ArrayList<Pet> pets = pc.createList(10);
      Apply.apply(pets,Pet.class.getMethod("speak"));
    }
}