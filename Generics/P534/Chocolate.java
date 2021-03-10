package ThinkingInJava.Generics.P534;

import java.awt.*;

public class Chocolate extends DecoratorCoffee {
    Color color;
    public Chocolate(BasicCoffee basicCoffee, Color color){
        super(basicCoffee);
        this.color = color;
        setType(getType() + " " + getColor() + " & Chocolate");
    }
    public Color getColor(){ return color;}
}
