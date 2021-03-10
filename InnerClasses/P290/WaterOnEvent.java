package ThinkingInJava.InnerClasses.P290;

public class WaterOnEvent extends EventFactory{
    @Override
    public Event createEvent(long delayTime) {
        return gc.new WaterOn(delayTime);
    }
}
