package ThinkingInJava.IO.P701;
//Exercise 22: (5) Modify OSExecuteDemo.java so that, instead of printing
// the standard output stream, it returns the results of executing
// the program as a List of Strings. Demonstrate the use of this new version of the utility.
import java.io.*;
import java.util.*;

class OSExecute {
    public static List<String> command(String command) {
        boolean err = false;
        List<String> list = new ArrayList<>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s = results.readLine()) != null)
                list.add(s);
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            if(!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else throw new RuntimeException(e);
        }
        if(err) throw new OSExecuteException("Errors executing " + command);
        return list;
    }
}
public class OSExecuteDemo {
    public static void main(String[] args) {
     List<String> result = OSExecute.command("javap C:\\Users\\phaet\\YandexDisk\\Programming\\TIJ tasks\\ThinkingInJavaTasks\\out\\production\\ThinkingInJavaTasks\\ThinkingInJava\\production\\ThinkingInJavaTasks\\ThinkingInJava\\Util\\Test2");
       // for(String s : result)
         //   System.out.println(s);
    }
}
