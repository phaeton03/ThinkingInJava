package ThinkingInJava.typeinfo.P435;

public class Holder<T> {
    private T a;
    public Holder(){}
    public Holder(T a){ this.a = a; }
    public T getA(){ return a;}
    public void setA(T a){ this.a = a; }

    public static void main(String[] args) {
        Holder<Pet> pet1 = new Holder<>(new Pet());
        System.out.println(pet1.getA().getClass().getSimpleName());
        Holder<Pet> pet2 = new Holder<>(new Cat());
        System.out.println(pet2.getA().getClass().getSimpleName());
        Holder<Pet> pet3 = new Holder<>(new Gerbil());
        System.out.println(pet3.getA().getClass().getSimpleName());
    }
}
