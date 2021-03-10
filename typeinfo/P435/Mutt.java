package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }
    public Mutt() {
        super();
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Mutt>{
        public Mutt create(){
            return new Mutt();
        }
    }

    @Override
    public void speak() {
        System.out.println(this + " Mutt");
    }
}
