package ThinkingInJava.Generics.P466;
class Test{}
public class TwoTuple<A, B> implements Comparable<TwoTuple<A,B>> {
    public final A first;
    public final B second;
    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public int compareTo(TwoTuple<A,B> o) {

        int res = ((Comparable<A>) first).compareTo(o.first);
        if (res != 0) return res;
        return ((Comparable<B>) second).compareTo(o.second);
    }

    @Override
    public String toString() {
        return "( " + first + ", " + second + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TwoTuple) {
            @SuppressWarnings("unchecked")
            TwoTuple<A, B> o = (TwoTuple<A, B>) obj;
            return first == null ? o.first == null : first.equals(o.first) &&
                    (second == null ? o.second == null : second.equals(o.second));
        }
    return false;
    }
    @Override
    public int hashCode() {
        int result = 17;
        if(first != null)
        result = 37 * result + first.hashCode();
        if(second != null)
        result = 37 * result + second.hashCode();
        return result;
    }

    public static void main(String[] args) {
        TwoTuple<String,String> tupleOne = new TwoTuple<>("Comp","Sre");
        TwoTuple<String,String> tupleSec = new TwoTuple<>("Spec","Sre2");
        System.out.println(tupleOne.compareTo(tupleSec));
        System.out.println("Comp".compareTo("Comp"));
    }
}
