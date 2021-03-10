package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }
    public Cymric() {
        super();
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Cymric>{
        public Cymric create(){
            return new Cymric();
        }
    }
}
