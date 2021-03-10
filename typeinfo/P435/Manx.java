package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Manx extends Cat{
    public Manx(String name) {
        super(name);
    }
    public Manx() {
        super();
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Manx>{
        public Manx create(){
            return new Manx();
        }
    }

    @Override
    public void speak() {
        System.out.println(this + " Manx");
    }
}
