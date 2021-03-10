package ThinkingInJava.Generics.P496;

interface FactoryI<T>{
    T create(int arg);
}

class Foo2<T> {
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory, int arg){
        x = factory.create(arg);
    }
}

class IntegerFactory implements FactoryI<Integer>{
    @Override
    public Integer create(int arg) {
        return new Integer(arg);
    }
}

class Widget{
    public static class Factory implements FactoryI<Widget>{
        public Widget create(int arg){
            return new Widget();
        }
    }
}
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory(),8);
        new Foo2<Widget>(new Widget.Factory(),66);
    }
}
