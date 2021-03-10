package ThinkingInJava.ContainersInDepth.P615;
//Exercise 10: (7) Using a LinkedList as your underlying
// implementation, define your own SortedSet.

import java.util.*;

public class CustomSortedSet<T extends Comparable<T>> {
    LinkedList<T> linkedList = new LinkedList<>();
    Class<T> type;
    Comparator<T> comparator;
    public CustomSortedSet(Set<T> set, Comparator<T> comparator) {
        this.comparator = comparator;
        this.linkedList.addAll(set);
        this.linkedList.sort(comparator);
    }
    public CustomSortedSet() { comparator = null; }
    public CustomSortedSet(Comparator<T> comparator) { this.comparator = comparator; }
    public T first(){ return linkedList.get(0); }
    public T last(){ return linkedList.get(linkedList.size() - 1); }
    public T get(int i){
        if (i < 0 || i >= linkedList.size()) throw new IndexOutOfBoundsException();
        return linkedList.get(i);
    }
    public CustomSortedSet<T> subSet(T element1, T element2){
        int index1 = Collections.binarySearch(linkedList, element1, comparator);
        int index2 = Collections.binarySearch(linkedList, element2, comparator);
        if (index1 < 0 || index2 < 0) throw new NoSuchElementException();
        return new CustomSortedSet<T>(new HashSet(linkedList.subList(index1, index2)), comparator);
    }
    public CustomSortedSet<T> headSet(T head){
         CustomSortedSet<T> set = this.subSet(this.first(), head);
         set.add(head);
         return set;
    }
    public int size() { return linkedList.size(); }
    public CustomSortedSet<T> tailSet(T tail){
        CustomSortedSet<T> set = this.subSet(tail, this.last());
        set.add(this.last());
        return set;
    }
    public void add(T t){
        if (Collections.binarySearch(linkedList, t, comparator) < 0)
        linkedList.add(t);
        Collections.sort(linkedList, comparator);
    }
    public T remove(){ return linkedList.remove(); }
    public Iterator<T> iterator(){ return linkedList.iterator(); }
    Comparator<T> comparator(){ return comparator; }

    @Override
    public boolean equals(Object o) {
        return o instanceof CustomSortedSet &&
                linkedList.equals(((CustomSortedSet<?>) o).linkedList);
    }
    @Override
    public int hashCode() {
        return linkedList.hashCode();
    }
    @Override
    public String toString() {
        return linkedList.toString();
    }
}

class Test{
    public static void main(String[] args) {
        CustomSortedSet<String> set =
                new CustomSortedSet<>(
                        new HashSet<>(
                                Arrays.asList(
                                        "one one two three four five six seven eight nine".split(" "))), null);
        set.add("O");
        System.out.println(set);
        System.out.println(set.first());
        System.out.println(set.last());
        String low = set.first();
        String high = set.last();
       // set.add("o");
        Iterator<String> iter = set.iterator();
        System.out.println(set.size());
        for (int i = 0; i < set.size(); i++){
            if (i == 3) low = iter.next();
            else if (i == 7) high = iter.next();
            else iter.next();
        }
        System.out.println(low + " " + high);
        System.out.println(set.subSet(low, high));
        System.out.println(set.tailSet(low));
        System.out.println(set.headSet(high));

    }
}