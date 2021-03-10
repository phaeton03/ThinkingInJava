package ThinkingInJava.Containers.P319;
import java.util.*;
public class Ex24 {
    public static void main(String[] args) {
        String [] str = {"Cat", "Dog", "Tiger", "Elephant", "Lion"};
        LinkedHashMap<String, Ex24> lhm = new LinkedHashMap<>();
        for (int i = 0; i < str.length; i++)
            lhm.put(str[i], new Ex24());

        List<String> lhsKeys = new ArrayList<>(lhm.keySet());
        Collections.sort(lhsKeys);
        for (String s : lhsKeys)
            lhm.put(s, lhm.get(s));

        System.out.println(lhm);
    }
}
