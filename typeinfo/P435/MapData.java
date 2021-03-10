package ThinkingInJava.typeinfo.P435;
import java.util.*;
public class MapData {
    public static Map<Class<? extends Pet>, Integer> map(List<Class<? extends Pet>> list, int quantity){
        LinkedHashMap<Class<? extends Pet>, Integer> lhm = new LinkedHashMap<>();
        for (Class<? extends Pet> it : list)
            lhm.put(it,quantity);
        return lhm;
    }
}
