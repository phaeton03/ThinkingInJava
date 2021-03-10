package ThinkingInJava.Generics.P468;
import java.util.*;

class RandomListSelector<T>{
    public void show(int length, RandomList<T> rlist){
        for (int i = 0; i < length; i++){
            System.out.println(rlist.select());
        }
    }
}

class Generator{
    Random rand = new Random();
    public void fillInt(RandomList<Integer> rl, int length){
        for (int i = 0; i < length; i++)
            rl.add(rand.nextInt());
    }
    String alphabet = "ABCDEFGHHIKLMNOPRSTUVWXYZ";
    String fullAlphabet = alphabet + alphabet.toLowerCase() + "123456789";
    public void fillChar(RandomList<Character> rl, int length){
        for (int i = 0; i < length; i++)
            rl.add(fullAlphabet.charAt(rand.nextInt(fullAlphabet.length())));
    }
}

public class RandomList<T> {
    Random rand = new Random(47);
    private ArrayList<T> storage = new ArrayList<>();
    public void add(T t){ storage.add(t); }
    public T select(){
        return storage.get(rand.nextInt(storage.size()));
    }
    public void show(int length){
        for (int i = 0; i < length; i++)
        System.out.print(this.select() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Generator gen = new Generator();
        RandomList<String> rs = new RandomList<>();
        RandomList<Integer> rsInt = new RandomList<>();
        RandomList<Character> rsChar = new RandomList<>();
        for (String str: "Hello my darling! I arrived from UK tonight".split(" "))
            rs.add(str);
        rs.show(10);
        gen.fillInt(rsInt,10);
        rsInt.show(10);
        gen.fillChar(rsChar, 10);
        rsChar.show(10);
    }
}


