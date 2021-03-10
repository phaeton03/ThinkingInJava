package ThinkingInJava.IO.P672;

//Exercise 2: (2) Create a class called
// SortedDirList with a constructor that
// takes a File object and builds a sorted
// directory list from the files at that File.
// Add to this class two overloaded list( ) methods:
// the first produces the whole list, and the second
// produces the subset of the list that matches its argument (which is a regular expression).
//------------------------------------------------------------------------------------------
//Exercise 3: (3) Modify DirList.java (or one of its variants) so that it sums up the file sizes of the selected files.

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class SortedDirList {
    File path;
    private String[] list;
    public SortedDirList(File path) { this.path = path; }
    public String[] list() {
        list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
    public String[] list(String reg) {
        list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(reg);
            @Override
            public boolean accept(File file, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
    public long fileSize() {
        long fileSize = 0;
        for(String dir : list){
            fileSize += new File(path, dir).length();
        }
        return fileSize;
    }
    public static void main(String[] args) {
        File path = new File("src\\ThinkingInJava\\Util");
        SortedDirList sortedDirList = new SortedDirList(path);
        System.out.println(Arrays.toString(sortedDirList.list(".*\\.java")));
        System.out.println(sortedDirList.fileSize());
    }
}
