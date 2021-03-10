package ThinkingInJava.Generics.P517;

import ThinkingInJava.typeinfo.P435.Holder;

public class AutoboxTtest {
    public static void main(String[] args) {
        Holder<Integer> holder = new Holder<>(9);
        int a = holder.getA();
        System.out.println(a);
        holder.setA(15);
        System.out.println(holder.getA());
    }
}
