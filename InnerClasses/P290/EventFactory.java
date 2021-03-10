package ThinkingInJava.InnerClasses.P290;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class EventFactory {
    static GreenhouseControls gc = new GreenhouseControls();
    public static Map<String, EventFactory> eventFactoryMap = new LinkedHashMap<>();
      static {
        eventFactoryMap.put("FansOn", new FansOnEvent());
        eventFactoryMap.put("FansOff", new FansOffEvent());
        eventFactoryMap.put("LightOn", new LightOnEvent());
        eventFactoryMap.put("LightOff", new LightOffEvent());
        eventFactoryMap.put("WaterOn", new WaterOnEvent());
        eventFactoryMap.put("WaterOff", new WaterOffEvent());
        eventFactoryMap.put("ThermostatNight", new ThermostatNightEvent());
        eventFactoryMap.put("ThermostatDay", new ThermostatDayEvent());
        eventFactoryMap.put("Bell", new BellEvent());
    }

    public abstract Event createEvent(long delayTime);
   /* public void action(long delayTime) {
        Event event = createEvent(delayTime);
        event.action();
    }*/
}
