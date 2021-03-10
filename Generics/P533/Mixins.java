package ThinkingInJava.Generics.P533;

import java.util.*;

public class Mixins {
    public static void main(String[] args) {
        Mixin mx = new Mixin();
        mx.set("Value1");
        System.out.println(mx.get());
        System.out.println(mx.getColour());
        System.out.println(mx.getSerialNumber());
        System.out.println(mx.getStamp());
    }
}
