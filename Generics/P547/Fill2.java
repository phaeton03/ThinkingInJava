package ThinkingInJava.Generics.P547;

import ThinkingInJava.typeinfo.P435.Pet;
import ThinkingInJava.typeinfo.P435.*;

import java.util.*;
//Exercise 41:   (1) Modify Fill2.java to use the
// classes in typeinfo.pets instead of the Coffee classes.

interface Addable<T>{
    void add(T t);
}
public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> type, int size){
        try {
            for (int i = 0; i < size; i++)
                addable.add(type.newInstance());
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
}

class AddableCollection<T> implements Addable<T>{
    Collection<T> coll;
    public AddableCollection(Collection<T> coll) {
        this.coll = coll;
    }
    @Override
    public void add(T t) { coll.add(t); }
}

class Adapter{
    public static<T> Addable<T> collectionAdapter(Collection<T> coll){
        return new AddableCollection<T>(coll);
    }
}

class AdapterTest{
    public static void main(String[] args) {
        List<Pet> listPet = new ArrayList<>();
        Fill2.fill(Adapter.collectionAdapter(listPet),Cat.class,2);
        Fill2.fill(Adapter.collectionAdapter(listPet),Manx.class,2);
        Fill2.fill(Adapter.collectionAdapter(listPet),Dog.class,2);
        for (Pet pet: listPet )
            System.out.println(pet);
    }
}

