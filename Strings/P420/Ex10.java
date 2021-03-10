package ThinkingInJava.Strings.P420;

public class Ex10 {
    public static void main(String[] args) {
        char [] ch = {'g','b', 'f', 'a'};
        int [] num ={90, 99,66};
        System.out.println(ch[0]);
        System.out.println(ch.getClass().getName());
        System.out.println(num.getClass().getName());
        System.out.println(num.getClass().getSuperclass().getName());
    }
}
