package ThinkingInJava.typeinfo.P435;

import java.util.HashMap;

public class PetCount2 {
    static class PetCounter extends HashMap<Class<? extends Pet>, Integer> {
        public void count(Class<? extends Pet> type) {
            Integer quantity = get(type);
            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }
public static void countPets(LiteralPetCreator creator) {
        PetCounter counter = new PetCounter();
  //      HashMap<Class<? extends Pet>, Integer> hashMap = new HashMap<>();
        for (Pet pet : creator.createArray(20)) {
            System.out.println(pet.getClass().getSimpleName() + " ");
            for (Class cls: creator.types()){
//                int quantity = hashMap.get(cls);
                if (cls.equals(pet.getClass())) counter.count(cls);
            }
        }
    System.out.println();
    System.out.println(counter);
}

    public static void main(String[] args) {
        countPets(new LiteralPetCreator());
    }
}
