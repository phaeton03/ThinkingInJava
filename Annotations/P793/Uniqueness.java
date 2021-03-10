package ThinkingInJava.Annotations.P793;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
