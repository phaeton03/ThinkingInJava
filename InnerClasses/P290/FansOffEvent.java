package ThinkingInJava.InnerClasses.P290;

public class FansOffEvent extends EventFactory{
    @Override
    public Event createEvent(long delayTime) {
        return gc.new FansOff(delayTime);
    }
}
