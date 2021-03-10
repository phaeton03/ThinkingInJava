package ThinkingInJava.typeinfo.P435;

public class PetCount6 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(10)){
            System.out.println(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
