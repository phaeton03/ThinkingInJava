package ThinkingInJava.Generics.P527;

class A{}
abstract class Base<T extends Base<T>>{
    public abstract T f(T t);
    public T g(T t){
        return f(t);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
class BaseGeneric extends Base<BaseGeneric>{
    @Override
    public BaseGeneric f(BaseGeneric baseGeneric) {
        return new BaseGeneric();
    }
}
public class SelfBoundedClass {
    public static void main(String[] args) {
        BaseGeneric genericBase = new BaseGeneric();
        System.out.println(genericBase.g(new BaseGeneric()));
    }
}
