package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class Pet extends Individual {
    public Pet(String name){
        super(name);
    }
    public Pet(){super();}
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<Pet>{
        public Pet create(){
            return new Pet();
        }
    }
    public void speak(){
        System.out.println(this + " " + getClass().getSimpleName());
    }
}
