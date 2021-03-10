package ThinkingInJava.Generics.P534;

public class BasicCoffee {
   String type;
    public BasicCoffee(){};
    public BasicCoffee(String type) { setType(type); }

    public void setType(String type){ this.type = type; }
    public String getType(){ return type; }
}
