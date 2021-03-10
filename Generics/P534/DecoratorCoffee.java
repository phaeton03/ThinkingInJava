package ThinkingInJava.Generics.P534;

class DecoratorCoffee extends BasicCoffee {
    public DecoratorCoffee(){}
    protected BasicCoffee basicCoffee;
    public DecoratorCoffee(BasicCoffee basicCoffee) {
        this.basicCoffee = basicCoffee;
    }
    public String getType(){ return basicCoffee.getType(); }
    public void setType(String arg){ basicCoffee.setType(arg); }
}
