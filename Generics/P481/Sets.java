package ThinkingInJava.Generics.P481;

import java.util.*;

public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    public static <T extends Enum<T>> EnumSet<T> union(EnumSet<T> a, EnumSet<T> b){
        Set<T> result = a.clone();
        result.addAll(b);
        return (EnumSet<T>) result;
    }
    public static <T> Set<T> intersection(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    public static <T extends Enum<T>> EnumSet<T> intersection(EnumSet<T> a, EnumSet<T> b){
        Set<T> result = a.clone();
        result.retainAll(b);
        return (EnumSet<T>) result;
    }
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset){
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }
    public static <T extends Enum<T>> EnumSet<T> difference(EnumSet<T> superset, EnumSet<T> subset){
        Set<T> result = superset.clone();
        result.removeAll(subset);
        return (EnumSet<T>) result;
    }
    public static <T> Set<T> complement(Set<T> a, Set<T> b){
        return difference(union(a,b), intersection(a,b));
    }
}
