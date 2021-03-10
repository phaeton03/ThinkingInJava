package ThinkingInJava.typeinfo.P435;

import java.util.*;

public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }
public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            System.out.println(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet)
                counter.count("ThinkingInJava.typeinfo.P435.Pet");
            if (pet instanceof Dog)
                counter.count("ThinkingInJava.typeinfo.P435.Dog");
            if (pet instanceof Mutt)
                counter.count("ThinkingInJava.typeinfo.P435.Mutt");
            if (pet instanceof Pug)
                counter.count("ThinkingInJava.typeinfo.P435.Pug");
            if (pet instanceof Cat)
                counter.count("ThinkingInJava.typeinfo.P435.Cat");
            if (pet instanceof Manx)
                counter.count("ThinkingInJava.typeinfo.P435.EgyptianMau");
            if (pet instanceof Manx)
                counter.count("ThinkingInJava.typeinfo.P435.Manx");
            if (pet instanceof Cymric)
                counter.count("ThinkingInJava.typeinfo.P435.Cymric");
            if (pet instanceof Rodent)
                counter.count("ThinkingInJava.typeinfo.P435.Rodent");
            if (pet instanceof Rodent)
                counter.count("ThinkingInJava.typeinfo.P435.Rat");
            if (pet instanceof Mouse)
                counter.count("ThinkingInJava.typeinfo.P435.Mouse");
            if (pet instanceof Hamster)
                counter.count("ThinkingInJava.typeinfo.P435.Hamster");
            if (pet instanceof Gerbil)
                counter.count("ThinkingInJava.typeinfo.P435.Gerbil");
        }
    System.out.println();
    System.out.println(counter);
}

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
