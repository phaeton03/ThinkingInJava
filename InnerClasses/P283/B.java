package ThinkingInJava.InnerClasses.P283;

public class B {
    private int nextI = 0;
    private int i = 0;
    private U[] u;

    public B(int size) {
        u = new U[10];
    }

    public void add(U x) {
        if (nextI < u.length)
            u[nextI++] = x;
    }

    public void remove(int i) {
        if (i < 0 || i >= u.length) {
            System.err.println("Error");
        } else {
            u[i] = null;
        }
    }

    public void next() {
        if (i < u.length) {
            u[i].next();
            u[i].end();
            u[i].previous();
            i++;
        }
    }

    public static void main(String[] args) {
        A[] a = {new A(), new A(), new A(), new A(), new A()};
        B b = new B(5);
        for (int i = 0; i < 5; i++) {
            b.add(a[i].u());
        }

        for (int i = 0; i < 5; i++){
            b.next();
        }
        b.remove(3);
        b.remove(0);
    }
}
