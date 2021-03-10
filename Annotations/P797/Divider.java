package ThinkingInJava.Annotations.P797;

////Exercise 2: (3) Add support for division to the interface extractor.

@ExtractorInterface("IDivider")
public class Divider {
    public double divider(int x, int y, int dig) {
         int ost = x % y;
         int cel = getCel(x - ost, y);
         return cel + (double) getCel(ost * dig, y) / dig;
    }
    private int getCel(int x, int y) {
        int cel = 0;
        while ( cel * y != x) cel++;
        return cel;
    }

    public static void main(String[] args) {
        Divider divider = new Divider();
        System.out.println(divider.divider(3,4,100));
    }
}
