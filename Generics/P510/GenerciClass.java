package ThinkingInJava.Generics.P510;

import ThinkingInJava.typeinfo.P435.*;

class Generic1<T>{
    T t;
    public void set(T t){
        this.t = t;
    }
}
class Generic2<T>{
    T t;
    public Generic2(T t) { this.t = t; }

    public T get(){
        return t;
    }
}
public class GenerciClass {
    public static <T>void contravarMethod(Generic1<? super T> generic1, T t){
        generic1.set(t);
    }
    public static <T>void covarMethod(Generic2<? extends T> generic2){
        T t = generic2.get();
        System.out.println(t);
    }
    public static void main(String[] args) {
        Number n = 10.6;
        Generic1<Pet> generic1 = new Generic1<>();
        contravarMethod(generic1, new Dog());
        System.out.println(generic1.t);
        Generic2<Cat> generic2 = new Generic2<>(new Cat());
        covarMethod(generic2);
    }
}
