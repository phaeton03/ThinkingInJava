package ThinkingInJava.Concurrency.P865;

//Exercise 15: (1) Create a class with three methods
// containing critical sections that all synchronize
// on the same object. Create multiple tasks to
// demonstrate that only one of these methods can run at
// a time. Now modify the methods so that each one
// synchronizes on a different object and show that all
// three methods can be running at once.

class OneTimeSync {
    private Object newObject = new Object();
    private Object newObject2 = new Object();
    public synchronized void f() {
        for(int i = 0; i < 50; i++) {
        System.out.println("f() " + System.currentTimeMillis());
        Thread.yield();
        }
    }
    public void g() {
        synchronized (newObject) {
        for(int i = 0; i < 50; i++) {
        System.out.println("g() " + System.currentTimeMillis());
        Thread.yield();
            }
        }
    }
    public synchronized void h() {
        synchronized (newObject2) {
        for(int i = 0; i < 50; i++) {
        System.out.println("h() " + System.currentTimeMillis());
        Thread.yield();
            }
        }
    }
}
public class SyncObject {
    public static void main(String[] args) {
        final OneTimeSync ots = new OneTimeSync();
        new Thread() {
            public void run() {
                ots.f();
            }
        }.start();
        new Thread() {
            public void run() {
                ots.g();
            }
        }.start();
        new Thread() {
            public void run() {
                ots.h();
            }
        }.start();
    }
}
