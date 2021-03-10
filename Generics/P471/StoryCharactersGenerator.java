package ThinkingInJava.Generics.P471;

import java.util.*;

public class StoryCharactersGenerator implements Iterable<StoryCharacters>, Generator<StoryCharacters> {
    public Class[] names = {BoogerMan.class, BatMan.class, BoogerMan.class, Goblin.class, Joker.class,
            ProfOctopus.class, SpiderMan.class};
    Random rand = new Random(47);
    private int count = 0;
    public StoryCharactersGenerator(){}
    public StoryCharactersGenerator(int count) { this.count = count; }

    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters) names[rand.nextInt(names.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    private class StoryCharacterIterator implements Iterator<StoryCharacters>{
        public boolean hasNext(){ return count > 0; }
        public StoryCharacters next(){
            count--;
            return StoryCharactersGenerator.this.next();
        }
    }
    public Iterator<StoryCharacters> iterator(){
        return new StoryCharacterIterator();
    }
}
