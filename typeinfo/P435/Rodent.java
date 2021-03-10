package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Rodent extends Pet {
    public Rodent(String name) {
        super(name);
    }
    public Rodent() {
        super();
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Rodent>{
        public Rodent create(){
            return new Rodent();
        }
    }
}
