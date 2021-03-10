package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Cat extends Pet{
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Cat>{
        public Cat create(){
            return new Cat();
        }
    }
}
