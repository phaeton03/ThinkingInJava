package ThinkingInJava.InnerClasses.P290;

public class ThermostatNightEvent extends EventFactory {
    @Override
    public Event createEvent(long delayTime) {
        return gc.new ThermostatNight(delayTime);
    }
}
