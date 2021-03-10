package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Rat extends Rodent {
    public Rat(String name) {
        super(name);
    }
    public Rat() {
        super();
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Rat>{
        public Rat create(){
            return new Rat();
        }
    }

    @Override
    public void speak() {
        System.out.println("Rat is speaking");
    }
}
