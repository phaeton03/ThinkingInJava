package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Dog extends Pet{
    public Dog(String name) {super(name);}
    public Dog() {super();}
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Dog>{
        public Dog create(){
            return new Dog();
        }
    }
}
