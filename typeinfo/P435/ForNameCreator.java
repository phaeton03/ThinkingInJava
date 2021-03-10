package ThinkingInJava.typeinfo.P435;

import java.util.*;

public class ForNameCreator extends PetCreator{
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {"ThinkingInJava.typeinfo.P435.Mutt", "ThinkingInJava.typeinfo.P435.Manx",
            "ThinkingInJava.typeinfo.P435.Pug", "ThinkingInJava.typeinfo.P435.EgyptianMau",
            "ThinkingInJava.typeinfo.P435.Cymric", "ThinkingInJava.typeinfo.P435.Rat",
            "ThinkingInJava.typeinfo.P435.Mouse", "ThinkingInJava.typeinfo.P435.Hamster",
            "ThinkingInJava.typeinfo.P435.Gerbil" };
    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for (String name : typeNames)
                types.add((Class<? extends Pet>) Class.forName(name));
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    static{ loader(); }
    public List<Class<? extends Pet>> types(){return types;}
}
