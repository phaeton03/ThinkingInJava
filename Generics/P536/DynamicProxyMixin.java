package ThinkingInJava.Generics.P536;

import ThinkingInJava.Generics.P466.TwoTuple;
import ThinkingInJava.Generics.P533.*;
import ThinkingInJava.Generics.P534.*;

import static ThinkingInJava.Generics.P478.Tuples.*;

import java.util.*;
import java.lang.reflect.*;

class MixinProxy implements InvocationHandler{
    Map<String,Object> container;
    public MixinProxy(TwoTuple<Object,Class<?>>... pairs) {
        container = new HashMap<>();
        for(TwoTuple<Object,Class<?>> pair : pairs)
            for (Method method : pair.second.getMethods()){
                String methodName = method.getName();
                if (!container.containsKey(methodName))
                    container.put(methodName,pair.first);
            }
    }
    public Object invoke(Object proxy, Method method, Object...args) throws Throwable{
        Object obj = container.get(method.getName());
        return method.invoke(obj,args);
    }
    public static Object newInstance(TwoTuple... pairs){
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++)
            interfaces[i] = (Class) pairs[i].second;
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(tuple(new ColourImp("white"),Coloured.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class),
                tuple(new TimeStampedImp(),TimeStamped.class));
        Coloured coloured = (Coloured) mixin;
        SerialNumbered sn = (SerialNumbered) mixin;
        TimeStamped ts = (TimeStamped) mixin;
        System.out.println(coloured.getColour());
        System.out.println(sn.getSerialNumber());
        System.out.println(ts.getStamp());
    }

}
