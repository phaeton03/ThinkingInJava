package ThinkingInJava.Generics.P481;
import java.util.*;
import static ThinkingInJava.Generics.P481.Watercolors.*;
import static ThinkingInJava.Generics.P481.Sets.*;

public class WatercolorsSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULIAN_BLUE_HUE, BURNT_UMBER);
        Set<Watercolors> unionSet = union(set1,set2);
        System.out.println("union [set1] and [set2] :" + union(set1,set2));
        System.out.println("intersection [set1] and [set2] :" + intersection(set1,set2));
        System.out.println("complement [set1] and [set2] :" + complement(set1,set2));
        System.out.println("difference [set1] and [set2] :" + difference(set1,set2));
    }
}
