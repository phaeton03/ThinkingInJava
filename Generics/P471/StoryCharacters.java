package ThinkingInJava.Generics.P471;

abstract class GoodGuys extends StoryCharacters{
    private static long counter = 1;
    private final long id = counter++;
    public static void resetCounter() {counter = 1;}
    @Override
    public String toString() { return getClass().getSimpleName() + " - GoodGuy number " + id; }
}
abstract class BadGuys extends StoryCharacters{
    private static long counter = 1;
    private final long id = counter++;
    public static void resetCounter() { counter = 1; }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - BadGuy number " + id;
    }
}
class BoogerMan extends GoodGuys{}
class BatMan extends GoodGuys{}
class SpiderMan extends GoodGuys{}
class Joker extends BadGuys{}
class ProfOctopus extends BadGuys{}
class Goblin extends BadGuys{}
public abstract class StoryCharacters {
    public static void main(String[] args) {
        StoryCharactersGenerator scgen = new StoryCharactersGenerator(10);
        for (StoryCharacters sc : scgen)
            System.out.println(sc);
    }
}


