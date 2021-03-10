package ThinkingInJava.Containers.P300;

import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Gerbil {
    private int gerbilNum;
    public Gerbil(int gerbilNum){
        this.gerbilNum = gerbilNum;
    }
    public void hop(){
        System.out.println(gerbilNum + " is hopping");
    }

    @Override
    public String toString() {
        return "Gerbil num " + gerbilNum ;
    }

    public static void main(String[] args) {
        String [] names = {"Fuzzy", "Spot", "Tweaks", "Mars", "MM"};
        Map<String, Gerbil> map = new HashMap<>();
        List<Gerbil> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            map.put(names[i], new Gerbil(i));
            arrayList.add(new Gerbil(i));
        }
      /*  for (Gerbil g: arrayList){
            g.hop();
        }
        System.out.println("\nIterator steps to the Game\n");
        Iterator<Gerbil> it = arrayList.iterator();
        while(it.hasNext())
            it.next().hop();*/

        Iterator<String> ite = map.keySet().iterator();
        while(ite.hasNext()){
            String next = ite.next();
            map.get(next).hop();
            System.out.println(map.get(next));
        }
    }
}
