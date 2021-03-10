package ThinkingInJava.ContainersInDepth.P647;

import java.util.*;
//Exercise 33: (5) Create a FastTraversalLinkedList that
// internally uses a LinkedList for rapid insertions and removals,
// and an ArrayList for rapid traversals and get( ) operations.
// Test it by modifying ListPerformance.java.

public class FastTraversalLinkedList<T> extends AbstractList<T>{
    private class FlaggedArrayList {
    private ArrayList<T> list = new ArrayList<>();
    private FlaggedLinkedList companion;  
    boolean changed = false;
    public void addCompanion(FlaggedLinkedList other) {
        companion = other;
    }
    private void synchronize() {
        if(companion.changed) {
            list = new ArrayList<T>(companion.list);
            companion.changed = false;
        }
    }
    public boolean add(T t) {
       synchronize();
       return list.add(t);
    }
    public T get(int i) {
        synchronize();
        return list.get(i);
    }

    public int size() {
        synchronize();
        return list.size();
    }
    public T remove(int index) {
        synchronize();
        changed = true;
        return list.remove(index);
    }
    public boolean remove(Object o) {
        synchronize();
        changed = true;
        return list.remove(o);
    }
    public Iterator<T> iterator() {
        synchronize();
        return list.iterator();
    }
    public void clear() {
        list.clear();
        changed = false;
    }
  }
  private class FlaggedLinkedList {
        private FlaggedArrayList companion;
        LinkedList<T> list = new LinkedList<>();
        boolean changed = false;
        public void addCompanion(FlaggedArrayList other) {
            companion = other;
        }
        private void synchronize() {
            if(companion.changed) {
                list = new LinkedList<>(companion.list);
                companion.changed = false;
            }
        }
        public boolean add(T o) {
            synchronize();
            changed = true;
            return list.add(o);
        }
        public void add(int index, T o) {
            synchronize();
            changed = true;
            list.add(index, o);
        }
        public Iterator<T> iterator() {
            synchronize();
            return list.iterator();
        }
        public void clear() {
            list.clear();
            changed = false;
        }
    }
    private FlaggedArrayList aList = new FlaggedArrayList();
    private FlaggedLinkedList lList = new FlaggedLinkedList();
    {
        aList.addCompanion(lList);
        lList.addCompanion(aList);
    }
    @Override
    public int size() { return aList.size(); }
    public T get(int index) { return aList.get(index); }
    @Override
    public boolean add(T t) { return lList.add(t); }
    @Override
    public void add(int index, T t) {
        lList.add(index, t);
    }
    @Override
    public T remove(int index) {
        return aList.remove(index);
    }
    @Override
    public boolean remove(Object o) {
        return aList.remove(o);
    }
    public Iterator<T> iterator() { return aList.iterator(); }
    public void clear() {
        aList.clear();
        lList.clear();
    }
}
class ListPerfomance3 {
    static Random random = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static {
        tests.add(new Test<List<Integer>>("iter"){
            @Override
           public int test(List<Integer> list, TestParam tp) {
                for(int i = 0; i < tp.loops; i++) {
                    Iterator<Integer> it = list.iterator();
                    while(it.hasNext()) it.next();
                }
                return tp.loops;
            }
        });
        tests.add(new Test<List<Integer>>("get"){
            @Override
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++)
                    list.get(random.nextInt(list.size()));
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("Insert"){
            @Override
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for(int i = 0; i < loops; i++)
                    list.add(5, 47); // Minimize Random cost
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove I "){
            @Override
            public int test(List<Integer> list, TestParam tp) {
                int count = 0;
                for(int i = list.size() / 2; i < list.size(); i++) {
                    ++count;
                    list.remove(i);
                }
                return count;
            }
        });
        tests.add(new Test<List<Integer>>("remove O "){
            @Override
            public int test(List<Integer> list, TestParam tp) {
                int count = 0;
                for(int i = list.size() / 2; i < list.size(); i++) {
                    ++count;
                    list.remove(list.get(i));
                }
                return count;
            }
        });
    }
    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountedIntegerList(size));
            return container;
        }
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }
    public static void main(String[] args) {
        ListTester.run(new ArrayList<>(), tests);
        ListTester.run(new LinkedList<>(), tests);
        ListTester.run(new FastTraversalLinkedList<Integer>(), tests);
    }
}
