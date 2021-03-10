package ThinkingInJava.ContainersInDepth.P610;

import ThinkingInJava.Arrays.P576.*;
import java.util.*;
//Exercise 8: (7) Create a generic, singly linked list class called SList,
// which, to keep things simple, does not implement the List interface. Each Link
// object in the list should contain a reference to the next element in the list, but not the
// previous one (LinkedList, in contrast, is a  doubly linked list, which means it maintains
// links in both directions). Create your own SListIterator which, again for simplicity,
// does not implement ListIterator. The only method in SList other than toString( )
// should be iterator( ), which produces an SListIterator.
// The only way to insert and remove elements from an SList
// is through SListIterator. Write code to demonstrate SList.
public class SList<T> {

    Link first;
    Link last;
    Link c;
    class Link{
        T current;
        Link next;
        public Link(T current, Link next) {
            this.current = current;
            this.next = next;
        }
    }
    class SListIterator {
        private int size = 0;

        public void add(T element){
            c = new Link(element,null);
            if (size == 0) {
                first = c;
                last = first;
            }else if(size == 1) {
                first.next = c;
                last = c;
            } else {
                last.next = c;
                last = c;
            }
        c = first;
        size++;
        }

        public T remove(int index){
        if (index < 0 || index > size -1) throw new IndexOutOfBoundsException();
        c = first;
        Link remove = null;
            if (index == 0) {
                remove = first;
                first = null;
                first = remove.next;
            } else
                for (int i = 0; i < index; i++, c = c.next) {
                if (i == index - 1) {
                    remove = c.next;
                    c.next = null;
                    c.next = remove.next;
                }
            }
        c = first;
        size--;
        return remove.current;
        }

        public T remove(){
            if (first == null) throw new NullPointerException();
                Link remove = first;
                first = first.next;
                size--;
                return remove.current;
        }

        public boolean hasNext(){
            boolean t = (c == null);
            if (t) c = first;
            return t;
        }
        public T next(){
            T result = c.current;
            c = c.next;
            return result;
        }
        public int size(){ return size; }
    }

    public SListIterator iterator(){
        return new SListIterator();
    }
}
class Test{
    public static void main(String[] args) {
        CountingGenerator.String cgs = new CountingGenerator.String();
        SList<String> names = new SList<>();
        SList.SListIterator itr = names.iterator();
        for (int i = 0; i < 5; i++)
            itr.add(cgs.next());
        System.out.println(itr.size());
        while(!itr.hasNext())
            System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println("/*******************/");
        System.out.println(itr.remove(1) + " " + itr.size());
        System.out.println(itr.remove(1) + " " + itr.size());
        System.out.println(itr.remove(1) + " " + itr.size());
    }
}
