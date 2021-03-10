package ThinkingInJava.Access.Local;

import java.sql.SQLOutput;

public class P193ex5 {
    public static void main(String[] args) {
    Root root = new Root();
    Stem stem = new Stem();
    stem.dispose();
    }
}

class Root{
    Component1 comp1 = new Component1(4);
    Component2 comp2 = new Component2(5);
    Component3 comp3 = new Component3(6);
    void dispose(){
        System.out.println("Shape dispose()");
    }
    void draw(){
        System.out.println("Shape is drawing");
    }
    void colour(String colour){
        System.out.println("The colour is " + colour);
    }
    void rotate(int degree){
        System.out.println("Shape is rotated on " + degree);
    }
    void getSquare(int square){
        System.out.println("The square is " + square);
    }
}

class Component1{
    Component1(int i){
        System.out.println("Instance of Component1");
    }
    void dispose(){
        System.out.println("Component1 dispose");
    }
}
class Component2{
    Component2(int i){
        System.out.println("Instance of Component2");
    }
    void dispose(){
        System.out.println("Component2 dispose()");
    }
}
class Component3{
    Component3(int i){
        System.out.println("Instance of Component3");
    }
    void dispose(){
        System.out.println("Component3 dispose");
    }
}

class Stem extends Root{
    Component1 comp1 = new Component1(1);
    Component2 comp2 = new Component2(2);
    Component3 comp3 = new Component3(3);
    @Override
    void dispose(){
        System.out.println("Stem dispose()");
        super.dispose();
    }
    @Override
    void draw(){
        System.out.println("The Stem is drawing");
    }
    @Override
    void colour(String s){
        System.out.println("The colour of stem is " + s);
    }
    @Override
    void getSquare(int s){
        System.out.println("The square of the Stem is " + s);
    }
}

class Flowers extends Stem{

}