package ThinkingInJava.Generics.P496;

import java.lang.reflect.*;
class B{}
class A{
    int num;

    public A(int num){
        this.num = num;
    }
    public A(){}

    @Override
    public String toString() {
        return "Parameter num is - " + num;
    }
}
public class TypeTagClass<T> {
     Class<T> typeinfo;
    public TypeTagClass(Class<T> typeinfo) { this.typeinfo = typeinfo; }

    private boolean hasParam(){
        Constructor[] ctor = typeinfo.getDeclaredConstructors();
        if (ctor.length > 1) return true;
        else return ctor[0].getParameters().length != 0;
    }
    public T create (int arg){
        if(hasParam())
        try {
            Constructor<T> ctor = typeinfo.getConstructor(Integer.TYPE);
            return ctor.newInstance(arg);
        }catch(Exception e){
            System.err.println(e);
        }else System.out.println("Only default constructor");
        return null;
    }

    public static void main(String[] args) {
        TypeTagClass<A> ttc = new TypeTagClass<>(A.class);
        TypeTagClass<B> ttcB = new TypeTagClass<>(B.class);
        B b = ttcB.create(7);
        A a = ttc.create(9);
        System.out.println(a);
    }
}
