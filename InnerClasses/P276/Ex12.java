package ThinkingInJava.InnerClasses.P276;

public class Ex12 {
    private int field = 9;

    private void print() {
        System.out.println("EX12 " + field);
    }

    public Outer outer(int i) {
        return new Outer() {
            public void change() {
                field = i;
                print();
            }
        };
    }
}

