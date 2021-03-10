package ThinkingInJava.Generics.P534;

class Foam extends DecoratorCoffee {
    public Foam(BasicCoffee basicCoffee){
        super(basicCoffee);
        setType(getType() + " & Foam");
    }
}
