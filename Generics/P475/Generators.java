package ThinkingInJava.Generics.P475;
import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Generics.P471.StoryCharacters;
import ThinkingInJava.Generics.P471.StoryCharactersGenerator;

import java.util.*;

public class Generators {
    public static <T> Collection<T> fill(Collection <T> coll, Generator<T> gen, int n){
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }
    public static <T> ArrayList<T> fill(ArrayList<T> list, Generator<T> gen, int n){
        for (int i = 0; i < n; i++)
            list.add(gen.next());
       // System.out.println("List");
        return list;
    }
    public static <T> Collection<T> fill(Queue<T> queue, Generator<T> gen, int n){
        for (int i = 0; i < n; i++)
            queue.add(gen.next());
        System.out.println("queue");
        return (Queue<T>) queue;
    }
    public static <T> LinkedList<T> fill(LinkedList<T> linkedList, Generator<T> gen, int n){
        for (int i = 0; i < n; i++)
            linkedList.add(gen.next());
        //System.out.println("LinkedList");
        return linkedList;
    }
    public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n){
        for (int i = 0; i < n; i++)
            set.add(gen.next());
        return set;
    }

    public static void main(String[] args) {
        LinkedList<StoryCharacters> linkedList =
                fill(new LinkedList<StoryCharacters>(), new StoryCharactersGenerator(), 5);
        for (StoryCharacters sc : linkedList)
            System.out.println(sc);
        System.out.println("----------------------------------------");
        ArrayList<StoryCharacters> arrayList = (ArrayList<StoryCharacters>)
                fill(new ArrayList<StoryCharacters>(), new StoryCharactersGenerator(), 5);
        for(StoryCharacters sc : arrayList)
            System.out.println(sc);
    }
}
