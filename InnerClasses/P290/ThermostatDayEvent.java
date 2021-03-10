package ThinkingInJava.InnerClasses.P290;

public class ThermostatDayEvent extends EventFactory {
    @Override
    public Event createEvent(long delayTime) {
        return gc.new ThermostatDay(delayTime);
    }
}
