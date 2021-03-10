package ThinkingInJava.Generics.P467;

public class LinkedStack<T> {
    private class Node{
        T item;
        Node next;
        Node(){ item = null; next = null; }
        Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
        boolean end(){ return item == null && next == null; }
    }
    private Node top = new Node();
    public void push(T item){
        top = new Node(item, top);
    }
    public T pop(){
        T result = top.item;
        if(!top.end())
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Hello my kitty".split(" "))
            lss.push(s);
        String s;
        while((s = lss.pop()) != null)
            System.out.println(s);
}
}
