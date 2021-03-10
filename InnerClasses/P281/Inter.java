package ThinkingInJava.InnerClasses.P281;

public interface Inter {
    static void print(){
        System.out.println("Inter class");
    }
    void test();
    class Nested implements Inter{
        public static void print(){

            Inter.print();
            System.out.print("Nested class ");
        }

        @Override
        public void test() {
        Inter nest = new Nested();
        }
    }

    static void main(String[] args) {
        Inter nest = new Nested();
        ((Nested) nest).print();
    }

}
