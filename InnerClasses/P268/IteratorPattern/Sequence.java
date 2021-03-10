package ThinkingInJava.InnerClasses.P268.IteratorPattern;

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

    private class SequenceSelector implements Selector{
        private int i = 0;

        @Override
        public void next() {
            if (i < items.length) i++;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public boolean end() {
            return i == items.length;
        }

        public Sequence sequence(){
            return new Sequence(10);
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }
}
