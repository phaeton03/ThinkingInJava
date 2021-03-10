package ThinkingInJava.Containers.P310;

import java.util.Iterator;

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object obj){
        if (next < items.length){
            items[next++] = obj;
        }
    }
    public int size(){
        return items.length;
    }

    private class SequenceSelector implements Iterator {
        private int i = 0;

        @Override
        public Object next() {
            if (i > next) i = 0;
                return items[i++];
        }
        @Override
        public void remove() {
        }
        @Override
        public boolean hasNext() {
            return i < next;
        }

        public Sequence sequence(){
            return new Sequence(10);
        }
    }
    public Iterator iterator(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
            Sequence seq = new Sequence(10);
            for (int i = 0; i < seq.size(); i++)
                seq.add("Privet " + i);
            Iterator it = seq.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
    }
}

