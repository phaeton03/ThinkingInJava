package ThinkingInJava.ContainersInDepth.P647;

public abstract class Test<C> {
    String name;
    public Test(String name) { this.name = name; }
    public abstract int test(C cont, TestParam tp);
}
