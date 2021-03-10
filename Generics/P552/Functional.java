package ThinkingInJava.Generics.P552;
//Exercise 42: (5) Create two separate classes,
// with nothing in common. Each class should hold a value,
// and at least have methods that produce that value and
// perform a modification upon that value.
// Modify Functional.java so that it performs
// functional operations on collections of your classes (
// these operations do not have to be arithmetic as they are in Functional.java).

import java.util.*;
interface Combiner<T>{
    T combine(T t1, T t2);
}
interface Strategy<T>{
    void set(T t);
    T get();
}
class Route{
    int route;
    public Route(int route) {
        this.route = route;
    }
    public void setRoute(int number){
        route = number;
    }
    public int getRoute(){
        return route;
    }
}

class Region{
    String name;
    public Region(String name) {
        this.name = name;
    }
    public void setRegion(String name){
        this.name = name;
    }
    public String getRegion(){
        return name;
    }
}

class RegionStrategy extends Region implements Strategy<String>{
    Region region;
    public RegionStrategy(Region region) {
        super(region.getRegion());
        this.region = region;
    }
    public void set(String name) { region.setRegion(name); }
    public String get() { return region.getRegion(); }
}
class RouteStrategy extends Route implements Strategy<Integer>{
    Route route;
    public RouteStrategy(Route route) {
        super(route.getRoute());
        this.route = route;
    }
    public void set(Integer number) { route.setRoute(number); }
    public Integer get() { return  route.getRoute(); }
}
public class Functional {
    public static <T> List<T> collect(Iterable<T> seq, Strategy<T> strategy){
        int count = 0;
        List<T> result = new ArrayList<>();
        Iterator<T> it = seq.iterator();
        while(it.hasNext()){
            strategy.set(it.next());
            result.add(strategy.get());
        }
        return result;
    }
    static class Concatenation implements Combiner<Strategy>{
        @Override
        public Strategy<String> combine(Strategy t1, Strategy t2) {
            String arg = t1.get() + " " + t2.get();
            Strategy<String> result = new RegionStrategy(new Region(arg));
            result.set(arg);
            return result;
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("First", "Second", "Third");
        System.out.println(collect(list, new RegionStrategy(new Region("i"))));
        Strategy<Integer> x = new RouteStrategy(new Route(66));
        Strategy<String> y = new RegionStrategy(new Region("Georgia"));
        Strategy<String> result = new Concatenation().combine(x,y);
        System.out.println(result.get());
    }
}
