package ThinkingInJava.Annotations.P793;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLArray {
    int size() default 0;
    String name() default "array";
    Constraints constraint() default @Constraints;
}
