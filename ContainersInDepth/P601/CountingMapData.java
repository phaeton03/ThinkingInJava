package ThinkingInJava.ContainersInDepth.P601;
//Exercise 5: (3) Modify CountingMapData.java to fully
// implement the flyweight by adding a custom EntrySet class like the one in Countries.java.
//Containers

import java.util.*;

import static ThinkingInJava.ContainersInDepth.P601.Countries.DATA;

public class CountingMapData extends AbstractMap<Integer,String>{
    public int size;
    private static String chars[] =
            "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ".split(" ");
    public CountingMapData(int size) {
        if(size < 0) this.size = 0;
        this.size = size;
    }
    private static class Entry implements Map.Entry<Integer,String>{
        int index;
        Entry(int index){ this.index = index; }
        @Override
        public boolean equals(Object obj) {
            return Integer.valueOf(index).equals(obj);
        }
        public Integer getKey(){ return index; }
        @Override
        public String getValue() { return chars[index % chars.length] +
                Integer.toString(index / chars.length); }
        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
    private static class EntrySet extends AbstractSet<Map.Entry<Integer,String>>{
        private int size;
        public EntrySet(int size) {
            if (size < 0)
            this.size = 0;
            this.size = size;
        }
        public int size(){ return size; }
        private class Iter implements Iterator<Map.Entry<Integer,String>>{
            private Entry entry = new Entry(-1);
            public boolean hasNext(){
                return entry.index < size - 1;
            }
            public Map.Entry<Integer, String> next(){
                entry.index++;
                return entry;
            }
            public void remove() { throw new UnsupportedOperationException(); }
        }
        public Iterator<Map.Entry<Integer, String>> iterator(){
            return new Iter();
        }
    }
    public Set<Map.Entry<Integer,String>> entrySet(){
        return new EntrySet(size);
    }
    public static void main(String[] args) {
        CountingMapData cmd = new CountingMapData(19);
        System.out.println(cmd.size());
        System.out.println(cmd);
    }
}
