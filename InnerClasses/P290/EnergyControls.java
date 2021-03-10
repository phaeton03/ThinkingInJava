package ThinkingInJava.InnerClasses.P290;

public class EnergyControls extends GreenhouseControls {
    private boolean waterGen = false;

    public class WaterGenOn extends Event{
        public WaterGenOn(long delayTime) {
        super(delayTime);
        }

        @Override
        public void action() {
            waterGen = true;
        }

        @Override
        public String toString() {
            return "Water generator is on";
        }
    }

    public class WaterGenOff extends Event{
        public WaterGenOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterGen = false;
        }

        @Override
        public String toString() {
            return "Water generator is off";
        }
    }
}
