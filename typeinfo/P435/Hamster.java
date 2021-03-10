package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Hamster extends Rodent {
    public Hamster(String name) {super(name);}
    public Hamster() {super();}
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Hamster>{
        public Hamster create(){
            return new Hamster();
        }
    }

    @Override
    public void speak() {
        System.out.println(this + "Hamster");
    }
}
