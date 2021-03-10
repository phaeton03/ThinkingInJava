package ThinkingInJava.Concurrency.P865;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Exercise 16: (1) Modify Exercise 15 to use explicit Lock objects.
class LockSync {
    private Lock lockF = new ReentrantLock();
    private Lock lockG = new ReentrantLock();
    private Lock lockH = new ReentrantLock();
    public synchronized void f() {
        lockF.lock();
        try {
        for(int i = 0; i < 10; i++) {
            System.out.println("f() " + System.currentTimeMillis());
            Thread.yield();
        }
        } finally {
            lockF.unlock();
        }
    }
    public void g() {
        lockG.lock();
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("g() " + System.currentTimeMillis());
                Thread.yield();
            }
        } finally {
            lockG.unlock();
        }
    }
    public void h() {
        lockH.lock();
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("h() " + System.currentTimeMillis());
                Thread.yield();
            }
        } finally {
            lockH.unlock();
        }
    }
}

public class LockObject {
    public static void main(String[] args) {
        final LockSync lockSync = new LockSync();
        new Thread() {
            public void run() {
                lockSync.f();
            }
        }.start();
        new Thread() {
            public void run() {
                lockSync.g();
            }
        }.start();
        new Thread() {
            public void run() {
                lockSync.h();
            }
        }.start();
    }
}
