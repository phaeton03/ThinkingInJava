package ThinkingInJava.Generics.P466;

interface Selector<T>{
    void next();
    boolean end();
    T current();
}
public class SequenceGenerify<T> {
    private T[] items;
    private int next = 0;
    public SequenceGenerify(int size) {items = (T[]) new Object[size];}
    public void add(T object){
        if (next < items.length){
            items[next++] = object;
        }
    }
    private class SequenceSelector implements Selector<T>{
        private int count = 0;
        @Override
        public boolean end() {return count < items.length;}
        @Override
        public void next() {if (count < items.length) count++;}
        @Override
        public T current() {return items[count];}
    }
    public Selector<T> selector() {return new SequenceSelector();}

    public static void main(String[] args) {
        SequenceGenerify<String> seq = new SequenceGenerify<>(5);
        seq.add("Privet");
        seq.add("Pepper");
        seq.add("Harry");
        seq.add("Potter");
        seq.add("Snake");
        Selector<String> selector = seq.selector();
        while(selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
    }
}
