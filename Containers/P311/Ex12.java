package Generics.P311;

import java.util.*;
public class Ex12 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(7,6,55,33,22,12345));
        List<Integer> list2 = new ArrayList<>(list.size());
        ListIterator<Integer> lit = list.listIterator();
        while(lit.hasNext())
            System.out.println(lit.next());
        ListIterator<Integer> lit2 = list.listIterator(list.size());
        System.out.println("/----------------------/");
        while(lit2.hasPrevious())
            list2.add(lit2.previous());
        for (Integer i : list2)
            System.out.println(i);
    }
}
