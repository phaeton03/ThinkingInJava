package ThinkingInJava.ContainersInDepth.P632;
import java.util.*;

public class SlowSet<E> extends AbstractSet<E> {
    SlowMap2<E, Object> slowMap2 = new SlowMap2<>();
    private final static Object PRESENT = new Object();
    @Override
    public boolean add(E e) { return slowMap2.put(e, PRESENT) == null; }
    @Override
    public void clear() { slowMap2.clear(); }
    @Override
    public Iterator<E> iterator() { return slowMap2.keySet().iterator(); }
    @Override
    public int size() { return slowMap2.size(); }

    public static void main(String[] args) {
        SlowSet<String> slowSet = new SlowSet<>();
        slowSet.add("FGHFH");
        slowSet.add("Nickolas");
        slowSet.add("Privet");
        slowSet.add("GHNF");
        System.out.println(slowSet);
        Iterator<String> iter = slowSet.iterator();
        System.out.println(slowSet.size());
    }
}
