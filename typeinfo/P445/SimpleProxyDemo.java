package ThinkingInJava.typeinfo.P445;

interface Interface{
void doSomething();
void somethingElse(String arg);
}

class RealObject implements Interface{
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }
    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    @Override
    public void doSomething() {
        long currentTime = System.nanoTime();
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
        long duration = System.nanoTime() - currentTime;
        System.out.println("Method-call time " + duration);
    }
    @Override
    public void somethingElse(String arg) {
        long start = System.nanoTime();
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        long duration = System.nanoTime() - start;
        System.out.println("Method-call time " + duration);
    }


}
 class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
