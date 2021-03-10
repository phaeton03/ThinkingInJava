package ThinkingInJava.Annotations.P800;

import java.lang.annotation.*;

import javax.annotation.processing.*;
import javax.lang.model.element.TypeElement;
import java.util.*;

//Exercise 3: (2) Add support for more SQL types to TableCreationProcessorFactory.java.
/*public class TableCreationProcessorFactory implements Processor {
    public Processor getProcessorFor(Set<TypeElement> atds, ProcessingEnvironment env) {
        return new TableCreationProcessor(env);
    }
    public Collection<String> supportedAnnotationTypes() {
        return Arrays.asList("ThinkingInJava.Annotations.P793.DBTable",
                "ThinkingInJava.Annotations.P793.Constraints",
                "ThinkingInJava.Annotations.P793.SQLString",
                "ThinkingInJava.Annotations.P793.SQLInteger");
    }
    public Collection<String> supportedOptions() {
        return Collections.emptyList();
    }
    private static class TableCreationProcessor implements Processor{
        private final ProcessingEnvironment env;
        private String sql = "";
        public TableCreationProcessor(ProcessingEnvironment env) {
            this.env = env;
        }

        @Override
        public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            for(TypeElement typeElement : annotations)
                typeElement.accept();
            return false;
        }

        public void process() {
            for(TypeElement typeElement : env.getTypeUtils())
        }
    }
}*/
