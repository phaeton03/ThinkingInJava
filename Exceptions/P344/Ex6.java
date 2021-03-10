package ThinkingInJava.Exceptions.P344;
import java.util.*;
import java.util.logging.Logger;
import java.io.*;

class MyException extends Exception{
 private static Logger logger = Logger.getLogger("LoggingMyExceprion");
static void logException(Exception e){
    StringWriter trace = new StringWriter();
    e.printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
}
}
class MyException2 extends Exception{

}
public class Ex6 {

}
