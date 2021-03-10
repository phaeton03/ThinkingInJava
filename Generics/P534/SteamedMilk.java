package ThinkingInJava.Generics.P534;

class SteamedMilk extends DecoratorCoffee {
    public SteamedMilk(BasicCoffee basicCoffee) {
        super(basicCoffee);
        setType(getType() + " & SteamedMilk");
    }
}
