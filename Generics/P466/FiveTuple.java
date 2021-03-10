package ThinkingInJava.Generics.P466;

public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D>{
    public final E fivth;
    public FiveTuple(A a, B b, C c, D d, E e){
        super(a,b,c,d);
        fivth = e;
    }
    public String toString(){
        return super.toString() + fivth;
    }
}
