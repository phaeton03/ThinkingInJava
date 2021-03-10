package ThinkingInJava.InnerClasses.P290;

public class BellEvent extends EventFactory {
    @Override
    public Event createEvent(long delayTime) {
        return gc.new Bell(delayTime);
    }
}
