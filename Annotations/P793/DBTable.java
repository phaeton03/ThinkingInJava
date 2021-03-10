package ThinkingInJava.Annotations.P793;

//Exercise 1: (2) Implement more SQL types in the database example.

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}

