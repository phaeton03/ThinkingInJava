package ThinkingInJava.IO.P744;

import java.util.Scanner;
import java.util.prefs.Preferences;

//Exercise 33: (2) Write a program that displays the current value
// of a directory called "base directory" and prompts you for a new value.
// Use the Preferences API to store the value.
public class PreferenceDemo {
    public static void main(String[] args) {
        Preferences pref = Preferences.userNodeForPackage(PreferenceDemo.class);
        String directory = pref.get("base directory", "Not found");
        System.out.println("oldValue : " + directory);
        System.out.println("Enter the new value");
        Scanner scan = new Scanner(System.in);
        directory = scan.nextLine();
        pref.put("base directory", directory);
        System.out.println("newValue : " + pref.get("base directory", "Not found"));
    }
}
