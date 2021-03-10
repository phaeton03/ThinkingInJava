package ThinkingInJava.InnerClasses.P290;

public class LightOffEvent extends EventFactory {
    @Override
    public Event createEvent(long delayTime) {
        return gc.new LightOff(delayTime);
    }
}
