package ThinkingInJava.Generics.P478;

import ThinkingInJava.Generics.P466.Plane;
import ThinkingInJava.Generics.P466.*;

public class TupleTest2 {
    public static TwoTuple<Plane, String> f(){
        return new TwoTuple<Plane,String>(new Plane(), "hi");
    }
    public static TwoTuple f2(){
        return new TwoTuple(new Plane(),"koko");
    }
    public static SixTuple<Plane, String, Long, Character, Integer, Float> f6(){
        return new SixTuple<Plane, String, Long, Character, Integer, Float>
                        (new Plane(), "Slovo", 200L,'g',10,55.7f);
    }

    public static void main(String[] args) {
        TwoTuple<Plane,String> twoTuple = f2();
        System.out.println(f6());
        System.out.println(twoTuple);
        System.out.println(f());
        System.out.println(f2());
    }
}
