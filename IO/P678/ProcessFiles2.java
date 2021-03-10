package ThinkingInJava.IO.P678;
//Exercise 6: (5) Use ProcessFiles to find all the
// Java source-code files in a particular directory
// subtree that have been modified after a particular date.


import ThinkingInJava.IO.P676.Directory;

import java.io.*;
import java.util.regex.Pattern;

public class ProcessFiles2 {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String reg;
    public ProcessFiles2(Strategy strategy, String reg) {
        this.strategy = strategy;
        this.reg = reg;
    }
    public void start(String[] args) {
        try {
            if(args.length == 0)
                processDirectoryTree(new File("."));
            else
                for(String arg : args) {
                    File fileArg = new File(arg);
                    if(fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        if(Pattern.compile(reg).matcher(arg).matches())
                            strategy.process(new File(arg).getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for(File file : Directory.walk(root.getAbsolutePath(), reg))
            strategy.process(file.getCanonicalFile());
    }

    public static void main(String[] args) {
        ProcessFiles2 pf = new ProcessFiles2(new Strategy() {
            @Override
            public void process(File file) {
                if(file.lastModified() > 9000000000000l)
                System.out.println(file);
            }
        },".*\\.java");
        try {
            pf.processDirectoryTree(new File("src\\ThinkingInJava\\Util"));
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
