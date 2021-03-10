package ThinkingInJava.InnerClasses.P266;

public class Outer {
    private String s;
    public Outer(String s){
        this.s = s;
    }
    public Inner getInner(){
        return new Inner();
    }
    public class Inner{
        public String toString(){
            return s;
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer("five");
        Outer.Inner oui = outer.getInner();
        System.out.println(oui);
    }
}
