package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Pug extends Dog {
    public Pug() {
        super();
    }
    public Pug(String name) {
        super(name);
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Pug>{
        public Pug create(){
            return new Pug();
        }
    }
}
