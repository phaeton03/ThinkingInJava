package ThinkingInJava.InnerClasses.P290;

public class WaterOffEvent extends EventFactory {
    @Override
    public Event createEvent(long delayTime) {
        return gc.new WaterOff(delayTime);
    }
}
