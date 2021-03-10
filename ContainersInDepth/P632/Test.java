package ThinkingInJava.ContainersInDepth.P632;

import ThinkingInJava.ContainersInDepth.P624.Maps;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashMap hm;
        SlowMap2<String,Integer> sm = new SlowMap2<>();
        sm.put("Tree", 11);
        sm.put("Branch", 23);
        sm.put("Root", 69);
        sm.put("Leaf", 9);
        Set<String> keys = sm.keySet();
        Iterator<Map.Entry<String, Integer>> ittr = sm.entrySet().iterator();
        System.out.println(sm.keySet().size());
       sm.keySet().removeAll(keys);
        //    Iterator<Map.Entry<String, Integer>> iter = sm.entrySet().iterator();
       // iter.remove();
        System.out.println(sm);
        sm.remove("Tree");
        //System.out.println(sm.isEmpty());
        Maps.test(new SlowMap2<>());
    }
}
