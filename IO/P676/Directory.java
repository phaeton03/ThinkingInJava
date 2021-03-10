package ThinkingInJava.IO.P676;
//Exercise 4: (2) Use Directory.walk( )
// to sum the sizes of all files in a
// directory tree whose names match a particular regular expression.

import ThinkingInJava.Util.PPrint;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public final class Directory {
    public static File[] local(File dir, final String reg) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(reg);
            public boolean accept(File file, String name){
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    public static File[] local(String path, final String reg) {
        return local(new File(path), reg);
    }
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        public long summFilesSize = 0;
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toString(){
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }
    }
    public static TreeInfo walk(String start, String reg) {
        return recurseDirs(new File(start), reg);
    }
    public static TreeInfo walk(File start, String reg) {
        return recurseDirs(start, reg);
    }
    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }
    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }
    static TreeInfo recurseDirs(File startDir, String reg) {
        TreeInfo result = new TreeInfo();
        for(File item : startDir.listFiles()) {
            if(item.isDirectory()) {
                result.dirs.add(item);
                // recursion !!!
                result.addAll(recurseDirs(item, reg));
            } else
                if(item.getName().matches(reg)) {
                    result.files.add(item);
                }
        }
        for(File files : result.files)
            result.summFilesSize += files.length();
        return result;
    }

    public static void main(String[] args) {
        File path = new File("src");
        TreeInfo t = walk(path);
        TreeInfo ti = walk(path, "Test.java");
        System.out.println(ti);
        System.out.println(t.summFilesSize);
    }
}
