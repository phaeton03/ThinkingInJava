package ThinkingInJava.IO.P759;

//Exercise 3: (1) Add a new Meal to Meal.java and demonstrate that it works in Meal.java.

public class Meal {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
