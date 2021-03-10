package ThinkingInJava.IO.P676;
//Exercise 5: (1) Modify ProcessFiles.java so that it matches a regular expression rather than a fixed extension.

import java.io.*;
import java.util.regex.Pattern;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String reg;
    public ProcessFiles(Strategy strategy, String reg) {
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
        ProcessFiles pf = new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },".*\\.java");
        pf.start(new String[]{"txt","Test","txt00.java"});
    }
}
