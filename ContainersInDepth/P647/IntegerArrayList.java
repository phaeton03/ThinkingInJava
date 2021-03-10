package ThinkingInJava.ContainersInDepth.P647;

//Exercise 32: (2) Repeat the previous exercise for a container of int,
// and compare the performance to an ArrayList<Integer>. In your
// performance comparison, include the process of incrementing each object in the container.

import java.util.*;

public class IntegerArrayList extends AbstractList<Integer> {
    public static List<Test<List<Integer>>> tests = new ArrayList<>();
    static {
        tests.add(new Test<List<Integer>>("add"){
            @Override
           public int test(List<Integer> cont, TestParam tp) {
                int loop = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loop; i++){
                    cont.clear();
                for(int j = 0; j < size; j++)
                    cont.add(j);
                }
                return loop * size;
            }
        });
        tests.add(new Test<List<Integer>>("get"){
            @Override
           public int test(List<Integer> cont, TestParam tp) {
                Random rand = new Random();
                int loop = tp.loops;
                for(int i = 0; i < loop; i++)
                    cont.get(rand.nextInt(cont.size()));
                return loop;
            }
        });
    }
    private int size = 0;
    private int cap = 0;
    private static final int CAP = 10;
    int[] cont;
    public IntegerArrayList(int cap) {
        cap = size;
        cont = new int[cap];
    }
    public IntegerArrayList() {
        cont = new int[CAP];
    }
    @Override
    public int size() { return size; }
    @Override
    public boolean add(Integer integer) {
        if(size >= cont.length){
            int[] buf = cont;
            cont = new int[cont.length * 2];
            for(int i = 0; i < buf.length; i++)
                cont[i] = buf[i];
        }
        cont[size++] = integer;
        return true;
    }
    @Override
    public Integer get(int index) { return cont[index]; }

    @Override
    public void clear() {
        size = 0;
        if (cap == 0) cont = new int[CAP];
        else cont = new int[size];
    }

    public static void main(String[] args) {
        Tester<IntegerArrayList> test1 = new Tester(new IntegerArrayList(), IntegerArrayList.tests);
        Tester<ArrayList<Integer>> test2 = new Tester(new ArrayList<Integer>(), IntegerArrayList.tests);
        test1.timedTest();
        test2.timedTest();
    }
}
