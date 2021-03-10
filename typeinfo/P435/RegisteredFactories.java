package ThinkingInJava.typeinfo.P435;
import ThinkingInJava.typeinfo.P435.factory.Factory;
import ThinkingInJava.typeinfo.P435.factory.Null;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

class NullPartProxyHandler implements InvocationHandler {
    private String name;
    private IPart proxied = new NPart();
    private class NPart implements Null, IPart{
        @Override
        public String toString() {
            return name;
        }
    }
    public NullPartProxyHandler(Class<? extends IPart> type) {
        name = type.getSimpleName() + " NullPart";
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        return method.invoke(proxied, args);
    }
}
interface IPart{
}
class Part implements IPart{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Factory<? extends IPart >> partFactories = new ArrayList<>();
    static List<Class<? extends IPart>> parts = new ArrayList<>();
    static{
        Collections.addAll(partFactories, new FuelFilter.Factory(), new AirFilter.Factory(),
                new CabinAirFilter.Factory(), new FanBelt.Factory(), new OilFilter.Factory(),
                new PowerSteeringBelt.Factory(), new GeneratorBelt.Factory(), new NullPart.Factory());
        Collections.addAll(parts, FuelFilter.class, AirFilter.class, CabinAirFilter.class, FanBelt.class,
                OilFilter.class, PowerSteeringBelt.class, GeneratorBelt.class);
          //  partFactories.add(pet.Factory.class.create());
    }
     /*   partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());*/

    private static Random rand = new Random(47);
    public static IPart createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}
class NullPart {
    private static Random rand = new Random(47);

    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<IPart>{
        public IPart create(){
            int i = rand.nextInt(Part.parts.size());
            Class<? extends IPart> type = Part.parts.get(i);
            return (IPart) Proxy.newProxyInstance(NullPart.class.getClassLoader(),
                    new Class[]{Null.class, IPart.class}, new NullPartProxyHandler(type));
        }
    }
}

class Filter extends Part{}

class FuelFilter extends Filter{
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<FuelFilter> {
        public  FuelFilter create(){
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter{
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<AirFilter>{
        public AirFilter create(){
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter{
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<CabinAirFilter>{
        public CabinAirFilter create(){
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter{
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<OilFilter>{
        public OilFilter create(){
            return new OilFilter();
        }
    }
}

class Belt extends Part{}

class FanBelt extends Belt{
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<FanBelt>{
        public FanBelt create(){
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt{
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<GeneratorBelt>{
        public GeneratorBelt create(){
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt{
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<PowerSteeringBelt>{
        public PowerSteeringBelt create(){
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(IPart.class);
        for (int i = 0; i < 20; i++){
            IPart part = Part.createRandom();
            counter.count(part);
            System.out.println(part);
        }

        System.out.println();
        System.out.println(counter);
    }
}
