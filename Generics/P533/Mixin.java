package ThinkingInJava.Generics.P533;

public class Mixin extends BasicImp implements  TimeStamped, SerialNumbered, Coloured{
    TimeStamped ts = new TimeStampedImp();
    SerialNumbered sn = new SerialNumberedImp();
    Coloured coloured = new ColourImp("Blue");
    public long getStamp(){ return ts.getStamp();}
    public long getSerialNumber(){ return sn.getSerialNumber(); }
    @Override
    public String getColour() { return coloured.getColour(); }
}
