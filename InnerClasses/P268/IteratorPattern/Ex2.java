package ThinkingInJava.InnerClasses.P268.IteratorPattern;

public class Ex2 {
    private static int i = 0;
    private String st;

    public Ex2(String st) {
        this.st = st;
        i++;
    }

    public String toString() {
        return "Ex2 instance " + st;
    }

    public static void main(String[] args) {
        Sequence seq = new Sequence(10);

        for (int i = 0; i < 10; i++) {
            seq.add(new Ex2(i + ""));
        }
        Selector iterator = seq.selector();

        while (!iterator.end()) {
            System.out.println(iterator.current());
            iterator.next();
        }

        Selector select = seq.selector();
    }
}
