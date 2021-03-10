package ThinkingInJava.ContainersInDepth.P653;
//Exercise 35: (1) Modify MapPerformance.java to include tests of SlowMap.

import ThinkingInJava.ContainersInDepth.P632.SlowMap;
import ThinkingInJava.ContainersInDepth.P632.SlowMap3;
import ThinkingInJava.ContainersInDepth.P632.SlowMap4;
import ThinkingInJava.ContainersInDepth.P634.SimpleHashMap;
import ThinkingInJava.ContainersInDepth.P634.SimpleHashMap2;
import ThinkingInJava.ContainersInDepth.P634.SimpleHashMap3;
import ThinkingInJava.ContainersInDepth.P647.*;

import java.util.*;

public class MapPerfomance {
    static List<Test<Map<Integer, Integer>>> tests = new ArrayList<>();
    static {
        tests.add(new Test<Map<Integer, Integer>>("put"){
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++){
                    map.clear();
                    for(int j = 0; j < size; j++)
                        map.put(j, j);
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for(int i = 0; i < loops; i++)
                    for(int j = 0; j < span; j++)
                        map.get(j);
            return loops * span;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate"){
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i++) {
                    Iterator it = map.entrySet().iterator();
                    while(it.hasNext())
                        it.next();
                }
            return loops * map.size();
            }
        });
    }
    public static void main(String[] args) {
        /* Tester.run(new SlowMap<Integer, Integer>(), tests, TestParam.array(1000, 5000));
         Tester.run(new SlowMap3<Integer, Integer>(), tests, TestParam.array(1000, 5000));
         Tester.run(new SlowMap4<Integer, Integer>(), tests, TestParam.array(1000, 5000));*/
        /* Tester.run(new SimpleHashMap3<Integer, Integer>(), tests);
         Tester.run(new SimpleHashMap2<Integer, Integer>(), tests);
         Tester.run(new SimpleHashMap<Integer, Integer>(), tests);*/
      /*   HashMap<Integer,Integer> hm1 = new HashMap<>(16);
         HashMap<Integer,Integer> hm2 = new HashMap<>(16,0.4f);
         HashMap<Integer,Integer> hm3 = new HashMap<>(16,0.9f);
         Tester.run(hm1, tests);
         Tester.run(hm2, tests);
         Tester.run(hm3, tests);*/
        System.out.println((float) 9 / 4);
         /* SlowMap4<Integer, Integer> sm4 = new SlowMap4<>();
        Random random = new Random(47);
        for(int i = 0; i < 2; i++)
            sm4.put(random.nextInt(50), random.nextInt(100));
        System.out.println(sm4);
        System.out.println("key = 4, value " + sm4.get(48));
        for(int i = 0; i < sm4.size(); i++)
            sm4.put(i,i);
        System.out.println(sm4);
        System.out.println(sm4.size());*/
    }
}
