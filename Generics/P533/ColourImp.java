package ThinkingInJava.Generics.P533;

public class ColourImp implements Coloured{
    private String colour;
    public ColourImp(String colour) {
        this.colour = colour;
    }
    @Override
    public String getColour() { return colour; }
}
