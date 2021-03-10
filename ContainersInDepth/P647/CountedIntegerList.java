package ThinkingInJava.ContainersInDepth.P647;

import java.util.*;
public class CountedIntegerList extends AbstractList<Integer> {
    private int size;
    public CountedIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }
    @Override
    public int size() { return size; }
    @Override
    public Integer get(int index) { return Integer.valueOf(index); }
}
