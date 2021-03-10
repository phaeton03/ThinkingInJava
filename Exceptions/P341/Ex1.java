package ThinkingInJava.Exceptions.P341;

public class Ex1 {
    public static void main(String[] args) {
        try{
            throw new Exception("Exception 1");
        }catch(Exception e){
            System.err.println(e);
        }finally{
            System.out.println("Inside finally clause");
        }
    }
}
