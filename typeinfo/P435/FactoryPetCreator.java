package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

import java.lang.reflect.Field;
import java.util.*;
public class FactoryPetCreator extends PetCreator {
    private Random rand = new Random(47);
    public static final List<Factory<? extends Pet>> allTypesFactory = Arrays.asList(new Pet.Factory(),
            new Dog.Factory(), new Cat.Factory(), new Rodent.Factory(), new Mutt.Factory(),
            new Pug.Factory(), new EgyptianMau.Factory(), new Manx.Factory(), new Cymric.Factory(),
    new Rat.Factory(), new Mouse.Factory(), new Hamster.Factory(), new Gerbil.Factory());
    private static final List<Factory<? extends Pet>> types
            = allTypesFactory.subList(5,allTypesFactory.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return null;
    }

    @Override
    public Pet randomPet() {
        int n = rand.nextInt(types.size());
        Pet pet = types.get(n).create();
        return pet;
    }
}

