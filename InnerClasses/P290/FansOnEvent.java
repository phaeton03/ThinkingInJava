package ThinkingInJava.InnerClasses.P290;

public class FansOnEvent extends EventFactory{
    @Override
    public Event createEvent(long delayTime) {
        return gc.new FansOn(delayTime);
    }
}
