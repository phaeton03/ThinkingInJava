package ThinkingInJava.Generics.P533;

public class BasicImp implements Basic{
    private String value;
    @Override
    public void set(String val) { value = val; }
    @Override
    public String get() { return value; }
}
