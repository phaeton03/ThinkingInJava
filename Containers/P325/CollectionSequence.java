package ThinkingInJava.Containers.P325;
import java.util.*;
class Pet{
    private static Pet[] pet;
    static private int count = 0;
    public Pet() {
        count++;
    }
    public static Pet [] createArray(int length){
        pet = new Pet[length];
        for (int i = 0; i < length; i++)
            pet[i] = new Pet();
            return pet;
    }
    @Override
    public String toString() {
        return "Number of Pet is " + count;
    }
}
class PetSequence{
    protected Pet [] pet = Pet.createArray(8);
}

public class CollectionSequence implements Collection{
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }
}
