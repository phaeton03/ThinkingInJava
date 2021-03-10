package ThinkingInJava.Generics.P515;

import ThinkingInJava.typeinfo.P435.Holder;
//import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.*;

public class Ex29 {
    public static void f(Holder<List<?>> holder){
        List list = holder.getA();
        System.out.println(holder.equals(list));
        Integer i = (Integer) list.get(0);
        System.out.println(i + " " +i.getClass().getSimpleName());
        System.out.println(list.contains(i));
        System.out.println(list.remove(i));
        holder.setA(new ArrayList<Float>());
    }
    public static void g(List<Holder<?>> listHolder){
        Holder<?> holder = (Holder<?>) listHolder.get(0);
        System.out.println(holder.equals(Integer.valueOf(1)));
        System.out.println(holder.getA());
        listHolder.add(new Holder<Float>(1.0f));
        System.out.println(listHolder.get(1).getA());
        listHolder.remove(0);
        System.out.println(listHolder.size());
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        f(new Holder<List<?>>(list1));
        List<Holder<?>> list2 = new ArrayList<Holder<?>>();
        list2.add(new Holder<Integer>(1));
        g(list2);
    }
}
