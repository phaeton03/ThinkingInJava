package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Null;

import java.util.*;

public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;
    public TypeCounter(Class<?> type){
        baseType = type;
    }
    public void count(Object obj){
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type))
            throw new RuntimeException(obj + " inoccorect type: " + type + ", should be a type or subtype of "
            + baseType);
        countClass(type);
    }
    private void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if(superClass != null && baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }
    public String toString(){
        StringBuilder result = new StringBuilder("{ ");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()){
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }
}
