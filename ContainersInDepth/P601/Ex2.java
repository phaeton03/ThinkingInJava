package ThinkingInJava.ContainersInDepth.P601;
//Exercise 2: (2) Produce a Map and a Set containing
// all the countries that begin with ‘A’.

import java.util.*;
import java.util.regex.*;

public class Ex2 {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        Pattern p = Pattern.compile("^A.*");
        for(int i = 0; i < Countries.DATA.length; i++){
            Matcher m = p.matcher(Countries.DATA[i][0]);
            if(m.matches()) {
                hashMap.put(Countries.DATA[i][0], Countries.DATA[i][1]);
                hashSet.add(Countries.DATA[i][0]);
            }
        }
        System.out.println(hashMap);
        System.out.println(hashSet);
    }
}
