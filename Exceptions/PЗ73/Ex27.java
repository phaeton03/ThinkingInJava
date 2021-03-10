package Exceptions.PЗ73;

public class Ex27 {
    public static void main(String[] args) {
        try{
            throw new ArrayIndexOutOfBoundsException();
        }catch(ArrayIndexOutOfBoundsException e){
            throw new RuntimeException();
        }
    }
}
