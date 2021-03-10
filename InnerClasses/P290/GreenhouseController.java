package ThinkingInJava.InnerClasses.P290;

import java.io.File;

public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        EnergyControls ec = new EnergyControls();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:

       /* gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new WaterOn(400),
                gc.new LightOn(200),
                ec.new ThermostatNight(0),
                ec.new FansOn(1000),
                gc.new FansOff(1200),
                ec.new WaterGenOn(1300),
                ec.new WaterGenOff(1355)
        };*/

    gc.addEvent(gc.new Restart(100000, new File("Events.txt")));
    gc.addEvent(new GreenhouseControls.Terminate(2000000));
    gc.run();
    }
}
