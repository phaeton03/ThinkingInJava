package ThinkingInJava.ContainersInDepth.P647;
//chapter.
//Exercise 29: (2) Modify ListPerformance.java
// so that the Lists hold String objects instead
// of Integers. Use a Generator from the Arrays
// chapter to create test values.

import ThinkingInJava.Arrays.P576.CountingGenerator;
import ThinkingInJava.ContainersInDepth.P601.CountingIntegerList;
import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Generics.P475.Generators;

import java.util.*;

public class ListPerfomanceString {
    static Random random = new Random();
    static Generator<String> gen = new CountingGenerator.String(3);
    static int reps = 1000;
    static List<Test<List<String>>> tests = new ArrayList<>();
    static List<Test<LinkedList<String>>> qTests = new ArrayList<>();
    static {
        tests.add(new Test<List<String>>("add") {
           public int test(List<String> list, TestParam tp) {
               int loops = tp.loops;
               int size = tp.size;
               for(int i = 0; i < loops; i++) {
                   list.clear();
                   for(int j = 0; j < size; j++){
                       list.add(gen.next());
                   }
               }
               return loops * size;
           }
        });
        tests.add(new Test<List<String>>("get") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++)
                    list.get(random.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<List<String>>("set") {
           public int test(List<String> list, TestParam tp){
                int loops = tp.loops * reps;
                int listSize = list.size();
                for(int i = 0; i < loops; i++)
                    list.set(random.nextInt(listSize), gen.next());
                return loops;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
           public int test(List<String> list, TestParam tp) {
               final int LOOPS = 1000_000;
               int half = list.size() /2;
               ListIterator<String> it = list.listIterator(half);
               for(int i = 0; i < LOOPS; i++)
                   it.add(gen.next());
               return LOOPS;
           }
        });
        tests.add(new Test<List<String>>("insert") {
           public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                for(int i = 0; i < loops; i++)
                    list.add(5, gen.next());
            return loops;
            }
        });
        tests.add(new Test<List<String>>("remove") {
          public int test(List<String> list, TestParam tp) {
             int loops = tp.loops;
             int size = tp.size;
             for(int i = 0; i < loops; i++) {
                 list.clear();
                 Generators.fill(list, gen, size);
                 while(list.size() > 5)
                     list.remove(5);
             }
            return loops * size;
           }
        });
        qTests.add(new Test<LinkedList<String>>("addFirst") {
          public int test(LinkedList<String> list, TestParam tp) {
               int loops = tp.loops;
               int size = tp.size;
               for(int i = 0; i < loops; i++) {
                   list.clear();
                   for(int j = 0; j < size; j++)
                       list.addFirst(gen.next());
               }
               return loops * size;
           }
        });
        qTests.add(new Test<LinkedList<String>>("addLast") {
          public int test(LinkedList<String> list, TestParam tp) {
               int loops = tp.loops;
               int size = tp.size;
               for(int i = 0; i < loops; i++){
                   list.clear();
                   for(int j = 0; j < size; j++)
                       list.addLast(gen.next());
               }
               return loops * size;
           }
        });
        qTests.add(new Test<LinkedList<String>>("rmFirst") {
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    Generators.fill(list, gen, size);
                    while(list.size() > 0)
                        list.removeFirst();
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("rmLast"){
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    Generators.fill(list, gen, size);
                    while(list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }
    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container, List<Test<List<String>>> tests){
            super(container, tests);
        }

        @Override
        protected List<String> initialize(int size) {
            container.clear();
            Generators.fill(container, gen, size);
            return container;
        }
        public static void run(List<String> list, List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        ListTester.run(new ArrayList<String>(), tests);
        ListTester.run(new LinkedList<String>(), tests);
        Tester<LinkedList<String>> qTest = new Tester<LinkedList<String>>(new LinkedList<String>(), qTests);
        qTest.timedTest();
    }
}
