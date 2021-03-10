package ThinkingInJava.Generics.P484;

import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Generics.P475.Generators;

import java.util.*;

class Product{
    private final int id;
    private String description;
    private double weight;
    public Product(int IDnumber, String descr, double weight){
        id = IDnumber;
        description = descr;
        this.weight = weight;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + " : " + description + ", weight: ton" + weight;
    }
    public static Generator<Product> generator = new Generator(){
        Random rand = new Random(47);
        public Product next(){
            return new Product(rand.nextInt(1000), "Army cargo",
                    Math.round(rand.nextDouble()*1000.0));
        }
    };
}

class Container extends ArrayList<Product>{
    public Container(int nProducts){
        Generators.fill(this, Product.generator,nProducts);
    }
}
class Ship extends ArrayList<Container>{
    public Ship(int nContainers, int nProducts){
        for (int i = 0; i < nContainers; i++)
            add(new Container(nProducts));
    }
}
public class Port extends ArrayList<Ship>{
    public Port(){}
    public Port(int nShips, int nCont, int nProducts){
        for (int i = 0; i < nShips; i++)
            add(new Ship(nCont,nProducts));
    }
    @Override
public String toString() {
    StringBuilder result = new StringBuilder();
        for(Ship a : this)
            for(Container c : a)
                for(Product p : c)
                    result.append(c);
    return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Port(3,6,10));
    }
}
