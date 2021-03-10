package ThinkingInJava.InnerClasses.P290;

import java.io.File;
import java.util.*;

public class GreenhouseControls extends Controller {

    private boolean fans = false;

    public class FansOn extends Event {
        public FansOn(long delayTime) { super(delayTime);}
        @Override
        public void action() {fans = true;}
        @Override
        public String toString() {
            return "Fans turn on";
        }
    }

    public class FansOff extends Event {
        public FansOff(long delayTime) {super(delayTime);}
        @Override
        public void action() {fans = false;}

        @Override
        public String toString() {
            return "Fans turn off";
        }
    }

    private boolean light = false;
    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        public void action() {
            light = true;
        }

        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            light = false;
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            water = true;
        }

        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        public String toString() {
            return "Greenhouse water is off";
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {
        public List<Event> eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = Arrays.asList(eventList);
            for (Event e : eventList)
                addEvent(e);
        }

        public Restart(long delayTime, File file) {
            super(delayTime);
            addEvent(file);
            eventList = getEventList();
        }

        @Override
        public void action() {
            for (Event e : new ArrayList<>(eventList)) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting System";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }


}
