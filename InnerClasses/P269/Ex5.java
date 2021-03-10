package ThinkingInJava.InnerClasses.P269;

public class Ex5 {
    public class Inner{
        public String toString(){
            return "Inner class";
        }
    }

    public static void main(String[] args) {
        Ex5 ex5 = new Ex5();
        Ex5.Inner inner = ex5.new Inner();
        Ex5.Inner inn = new Ex5().new Inner();
        System.out.println(inner);
    }
}
