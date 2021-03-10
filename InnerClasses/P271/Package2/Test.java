package ThinkingInJava.InnerClasses.P271.Package2;

import ThinkingInJava.InnerClasses.P271.Package1.TestInterface;

public class Test {
    protected void mix(){}
    protected class Inner implements TestInterface {
        public Inner(){}
        @Override
        public void printInof() {
            System.out.println("Test.Inner class");
        }
    }
}
