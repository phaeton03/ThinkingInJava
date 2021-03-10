package ThinkingInJava.ContainersInDepth.P647;

//chapter.
//Exercise 29: (2) Modify ListPerformance.java
// so that the Lists hold String objects instead
// of Integers. Use a Generator from the Arrays
// chapter to create test values.

import ThinkingInJava.Arrays.P576.CountingGenerator;
import ThinkingInJava.Arrays.P576.RandomGenerator;
import ThinkingInJava.ContainersInDepth.P601.CountingIntegerList;
import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Generics.P475.Generators;

import java.util.*;

public class ListPerfomance {
    static Random random = new Random();
    static Generator<Integer> gen = new CountingGenerator.Integer();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<>();
    static {
        tests.add(new Test<List<Integer>>("add") {
           public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < size; j++){
                        list.add(j);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<List<Integer>>("sort") {
           public int test(List<Integer> list, TestParam tp) {
               int loops = tp.loops;
               int size = tp.size;
               for(int i = 0; i < loops; i++){
                   list.clear();
                   Generators.fill(list, new RandomGenerator.RandomInteger(), size);
                   Collections.sort(list);
               }
               return loops * size;
           }
        });
        tests.add(new Test<List<Integer>>("get") {
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++)
                    list.get(random.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++)
                    list.set(random.nextInt(listSize), 47);
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iteradd") {
            public int test(List<Integer> list, TestParam tp) {
                final int LOOPS = 1000_000;
                int half = list.size() /2;
                ListIterator<Integer> it = list.listIterator(half);
                for(int i = 0; i < LOOPS; i++)
                    it.add(47);
                return LOOPS;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for(int i = 0; i < loops; i++)
                    list.add(5, 47);
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountedIntegerList(size));
                    while(list.size() > 5)
                        list.remove(5);
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            public int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    for(int j = 0; j < size; j++)
                        list.addFirst(47);
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addLast") {
           public int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++){
                    list.clear();
                    for(int j = 0; j < size; j++)
                        list.addLast(47);
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
            public int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountedIntegerList(size));
                    while(list.size() > 0)
                        list.removeFirst();
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmLast"){
            public int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountedIntegerList(size));
                    while(list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }
    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests){
            super(container, tests);
        }

        @Override
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
        //ListTester.run(new ArrayList<String>(), tests);
        Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTests);
        qTest.setHeadLine("Queue tests");
        qTest.timedTest();
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<>(), tests);
    }
}
