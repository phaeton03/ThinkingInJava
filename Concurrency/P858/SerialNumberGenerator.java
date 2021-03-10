package ThinkingInJava.Concurrency.P858;

public class SerialNumberGenerator {
    private static int serialNumber = 0;
    public synchronized static int nextSerialNumber() {
        return serialNumber++;
    }
}
