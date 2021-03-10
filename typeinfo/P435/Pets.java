package ThinkingInJava.typeinfo.P435;

import java.util.*;
public class Pets {
    public static final PetCreator creator = new FactoryPetCreator();
    public static Pet randomPet() {
        return creator.randomPet();
    }
    public static Pet[] createArray(int size){
        return creator.createArray(size);
    }
    public static ArrayList<Pet> createList(int size){
        return creator.createList(size);
    }
}
