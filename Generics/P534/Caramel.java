package ThinkingInJava.Generics.P534;

public class Caramel extends DecoratorCoffee {
    public Caramel() {}

    public Caramel(BasicCoffee basicCoffee){
        super(basicCoffee);
        setType(getType() + " & Caramel");
    }
}
