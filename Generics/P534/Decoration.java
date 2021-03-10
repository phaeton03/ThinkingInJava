package ThinkingInJava.Generics.P534;

import java.awt.*;

public class Decoration {
    public static void main(String[] args) {
        DecoratorCoffee capuchino =
                new SteamedMilk(new Foam(new Chocolate(new BasicCoffee("Capuchino"), Color.BLACK)));
        DecoratorCoffee espresso = new Caramel(new BasicCoffee("Espresso"));
        DecoratorCoffee darkCoffee = new Foam(new Chocolate(new BasicCoffee("Capuchino"), Color.ORANGE));
        BasicCoffee baseCoffee = new SteamedMilk(new Foam(new BasicCoffee("baseCoffee")));
        System.out.println(baseCoffee.getType());
        baseCoffee.setType("BEZE");
        System.out.println(baseCoffee.getType());
        System.out.println(capuchino.getType());
        capuchino.setType("corsar");
        System.out.println(capuchino.getType());
        System.out.println(espresso.getType());
        System.out.println(darkCoffee.getType());
    }
}
