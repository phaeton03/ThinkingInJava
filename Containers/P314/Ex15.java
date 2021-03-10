package Generics.P314;

public class Ex15 {
    public static void main(String[] args) {
        String s = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '+') {
                stack.push(ch[i + 1]);
                i++;
            } else if (ch[i] == '-')
                System.out.print(stack.pop());
        }
    }
}
