package ThinkingInJava.Annotations.P804;

import org.junit.jupiter.api.*;
import org.junit.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class UnitTest {
    public UnitTest() {
        System.out.println("new Object");
    }
}
public class JUnitTest {
    HashSet<String> testObject = new HashSet<>();
    UnitTest ut = new UnitTest();
    @DisplayName("is an emtpy set ?")
    @Test
    void initialization() {
        System.out.println(ut);
        assertTrue(testObject.isEmpty());
        testObject.add("two");
    }
    @DisplayName("Is this set contains \"one\" element ?")
    @Test
    void _containts() {
        System.out.println(ut);
        testObject.add("one");
        assertTrue(testObject.contains("one"));
    }
    @DisplayName("Is this set empty after removing?")
    @Test
    void _remove() {
        System.out.println(ut);
        testObject.add("one");
        testObject.remove("one");
        assertTrue(testObject.isEmpty());
    }
}
