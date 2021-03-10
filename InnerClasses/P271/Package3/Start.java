package ThinkingInJava.InnerClasses.P271.Package3;

import ThinkingInJava.InnerClasses.P271.Package1.TestInterface;
import ThinkingInJava.InnerClasses.P271.Package2.Test;

public class Start extends Test {
//    Test test = new Start();
    //Test start = new Start();
    public TestInterface test(){
        return new Start().new Inner();
    }

    public static void main(String[] args) {
        TestInterface tstI = new Start().test();
        System.out.println(tstI);
    }
}
