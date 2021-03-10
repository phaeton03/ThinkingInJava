package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }
    public Mouse() {
        super();
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Mouse>{
        public Mouse create(){
            return new Mouse();
        }
    }

    @Override
    public void speak() {
        System.out.println(this + " Mouse");
    }
}
