package ThinkingInJava.Concurrency.P851;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("Caught " + throwable);
    }
}
