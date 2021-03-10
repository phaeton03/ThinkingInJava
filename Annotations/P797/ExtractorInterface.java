package ThinkingInJava.Annotations.P797;

//Exercise 2: (3) Add support for division to the interface extractor.
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractorInterface {
    public String value();
}
