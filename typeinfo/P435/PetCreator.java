package ThinkingInJava.typeinfo.P435;

import java.util.*;
public abstract class PetCreator{
    private Random rand = new Random(47);
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet(){
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        }catch(IllegalAccessException e){
            throw new RuntimeException();
        }catch(InstantiationException e){
            throw new RuntimeException();
        }
    }

    public Pet[] createArray(int size){
        Pet[] result = new Pet[size];
        for (int i = 0; i < result.length; i++)
            result[i] = randomPet();
        return result;
    }

    public ArrayList<Pet> createList(int size){
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
