package ThinkingInJava.typeinfo.P445;

import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        //System.out.println(proxy);
    //    System.out.println("**** proxy : " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if(args != null)
            for (Object arg : args)
                System.out.println(" " + arg);
            Parameter[] prms = method.getParameters();
            for(Parameter prm : prms)
                System.out.println(prm);
        long start = System.nanoTime();
        Object result = method.invoke(proxied, args);
        long duration = System.nanoTime() - start;
        System.out.println("Method-call " + duration);
        return result;
    }
}
class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
     //   consumer(real);
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
