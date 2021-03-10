package ThinkingInJava.IO.P672;
//Exercise 1: (3) Modify DirList.java (or one of its variants)
// so that the FilenameFilter opens and reads each file
// (using the net.mindview.util.TextFile utility) and accepts
// the file based on whether any of the trailing arguments on the command line exist in that file.
import ThinkingInJava.Util.TextFile;

import java.io.*;
import java.util.regex.Pattern;
import java.util.*;
public class DirList {
    public static FilenameFilter filter(final String ext, final String... args) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name2) {
                if(name2.toLowerCase().endsWith(ext.toLowerCase())) {
                    Set<String> words =
                            new HashSet<>(new TextFile(new File(dir, name2).getAbsolutePath(), "\\W+"));
                    for(int i = 0; i < args.length; i++)
                    if(words.contains(args[i])) return true;
                }
                return false;
            }
        };
    }
    public static void main(String[] args) {
        File path = new File("src\\ThinkingInJava\\Util");
        String[] list;
        String ext = "java";
        list = path.list(filter(ext,"Test2","TextFile"));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}
