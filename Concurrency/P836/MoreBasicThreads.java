package ThinkingInJava.Concurrency.P836;

//Exercise 8: (1) Modify MoreBasicThreads.java so that
// all the threads are daemon threads, and verify that
// the program ends as soon as main( ) is able to exit.

import java.util.concurrent.TimeUnit;

public class MoreBasicThreads {
    public static void main(String[] args) throws Exception{
        for(int i = 0; i < 5; i++) {
           Thread daemon = new Thread(new LiftOff());
           daemon.setDaemon(true);
           daemon.start();
        }
        System.out.println("Waiting for LiftOff");
        TimeUnit.SECONDS.sleep(1);
    }
}
