package ThinkingInJava.Generics.P515;

import ThinkingInJava.typeinfo.P435.Holder;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder){
        T t = holder.getA();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder){
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.setA(new Object());
        f2(rawBasic);
        Holder<?> wildcarded = new Holder<>();
        //f2(wildcarded);

    }
}
