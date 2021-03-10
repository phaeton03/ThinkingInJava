package ThinkingInJava.IO.P759;

import ThinkingInJava.Util.Enums;
import java.util.*;

public enum Course {
    ALCOHOL(Food.Alcohol.class),
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
}
