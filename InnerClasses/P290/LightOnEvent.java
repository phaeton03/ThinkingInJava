package ThinkingInJava.InnerClasses.P290;

public class LightOnEvent extends EventFactory {
    @Override
    public Event createEvent(long delayTime) {
        return gc.new LightOn(delayTime);
    }
}
