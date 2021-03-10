package ThinkingInJava.IO.P740;

//Exercise 30: (1) Repair the program CADState.java as described in the text.

import java.io.*;
import java.util.*;

abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random random = new Random(47);
    private static int counter = 0;
    public abstract void setColor(int newColor);
    public abstract int getColor();

    public Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }
    @Override
    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" +
                yPos + "] dim[" + dimension + "]\n";
    }
    public static Shape randomFactory() {
        int xVal = random.nextInt(100);
        int yVal = random.nextInt(100);
        int dim = random.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0: return new Circle(xVal, yVal, dim);
            case 1: return new Square(xVal, yVal, dim);
            case 2: return new Line(xVal, yVal, dim);
        }
    }
}

class Circle extends Shape {
    private static int color = Shape.GREEN;
    public Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }
    public void setColor(int newColor) { color = newColor; }
    public int getColor() { return color; }
    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
}

class Square extends Shape {
    private static int color;
    public Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = Shape.RED;
    }
    public void setColor(int newColor) { color = newColor; }
    public int getColor() { return color; }
    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
}

class Line extends Shape {
    private static int color = Shape.RED;
    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
    public Line(int xVal, int yVal, int dim) {
        super(xVal,yVal,dim);
    }
    public void setColor(int newColor) {
        color = newColor;
    }
    public int getColor() { return color; }
}
public class CADState {
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<>();
        //Circle c = new Circle(0,0,0);
       // c.setColor(Shape.RED);
        for(int i = 0; i < 10; i++)
            shapes.add(Shape.randomFactory());
        for(int i = 0; i < 10; i++)
            shapes.get(i).setColor(Shape.RED);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        Circle.serializeStaticState(out);
        Square.serializeStaticState(out);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
     /*   ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        Circle.deserializeStaticState(in);
        Square.deserializeStaticState(in);
        Line.deserializeStaticState(in);
        List<Shape> iShapes = (ArrayList<Shape>)in.readObject();
       // System.out.println(iShapes);
        System.out.println(iShapes);*/
    }
}
