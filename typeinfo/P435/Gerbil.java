package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Gerbil extends Rodent {
    public Gerbil() {super();}
    public Gerbil(String name) {
        super(name);
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Gerbil>{
        public Gerbil create(){
            return new Gerbil();
        }
    }
}
