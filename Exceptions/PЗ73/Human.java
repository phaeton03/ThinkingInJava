package Exceptions.PЗ73;

import java.util.*;

class Annoyance extends RuntimeException{}
class Sneeze extends Annoyance{}

public class Human {
    public void diffExceptions(int i){
        try{
            switch(i) {
                case 0: throw new Annoyance();
                case 1: throw new Sneeze();
                default: throw new RuntimeException();
            }
        }catch(RuntimeException e){
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Human hm = new Human();
        Random random = new Random();
        try{
            hm.diffExceptions(random.nextInt(3));
        }catch(RuntimeException e){
            try{
                throw e.getCause();
            }catch (Sneeze s){
                System.out.println(s);
            }catch (Annoyance a){
                System.out.println(a);
            }catch (RuntimeException re){
                System.out.println(re);
            }catch (Throwable tr){
                System.out.println(tr);
            }
        }
    }
}
