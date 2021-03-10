package ThinkingInJava.ContainersInDepth.P601;

import java.util.*;

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }
    public Integer get(int index){
        return Integer.valueOf(index);
    }
    public int size(){ return size; }
}
