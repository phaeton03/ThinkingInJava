package ThinkingInJava.ContainersInDepth.P650;

import ThinkingInJava.Arrays.P576.CountingGenerator;
import ThinkingInJava.ContainersInDepth.P647.Test;
import ThinkingInJava.ContainersInDepth.P647.TestParam;
import ThinkingInJava.ContainersInDepth.P647.Tester;
import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Generics.P475.Generators;

import java.util.*;
//Exercise 34: (1) Modify SetPerformance.java
// so that the Sets hold String objects instead
// of Integers. Use a Generator from the Arrays chapter to create test values.

public class SetPerfomanceString {
    static List<Test<Set<String>>> tests = new ArrayList<>();
    static Generator<String> gen = new CountingGenerator.String(5);
    static {
        tests.add(new Test<Set<String>>("add"){
            @Override
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++){
                    set.clear();
                    Generators.fill(set, new CountingGenerator.String(5), size);
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            @Override
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for(int i = 0; i < loops; i++)
                    for(int j = 0; j < span; j++)
                        set.contains(gen.next());
                    return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate"){
            @Override
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        Tester.run(new TreeSet<String>(), tests);
        Tester.run(new HashSet<String>(), tests);
        Tester.run(new LinkedHashSet<String>(), tests);
    }
}
