package ThinkingInJava.InnerClasses.P291;

public class Ex26 {
    public class Inner{
        private int i;
        public Inner(int i){
            this.i = i;
        }

        @Override
        public String toString() {
            return "Ex26.Inner";
        }
    }

    @Override
    public String toString() {
        return "Ex26 class";
    }

    public static void main(String[] args) {
        Ex26 ex26 = new Ex26();
        Ex26.Inner exin = ex26.new Inner(9);
        Test test = new Test();
        Test.Inner testInner = test.new Inner(ex26, 100);
        System.out.println(ex26);
        System.out.println(exin);
        System.out.println(test);
        System.out.println(testInner);
    }
}

class Test {
    public class Inner extends Ex26.Inner{
        public Inner(Ex26 ex26, int i){
            ex26.super(i);
        }

        @Override
        public String toString() {
            return "Test.Inner";
        }
    }

    @Override
    public String toString() {
        return "TEST class";
    }
}
