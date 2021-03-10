package ThinkingInJava.IO.P773;

//Exercise 11: (7) In a real vending machine you will want to
// easily add and change the type of vended items, so the
// limits imposed by an enum on Input are impractical
// (remember that enums are for a restricted set of types).
// Modify VendingMachine.java so that the vended items are
// represented by a class instead of being part of Input,
// and initialize an Array List of these objects from a text file (using net.mindview.util.TextFile).
import java.util.*;
public class Item {
    String name;
    int value;
    Category cat;
    enum Category {
        MONEY, ITEM_SELECTION, QUIT_TRANSACTION, SHUT_DOWN;
    }
    final static Item
            DIME = new Item(Category.MONEY, 10),
            NICKEL = new Item(Category.MONEY,5),
            QUARTER = new Item(Category.MONEY, 25),
            DOLLAR = new Item(Category.MONEY, 100),
            ABORT_TRANSACTION = new Item(Category.QUIT_TRANSACTION),
            STOP = new Item(Category.SHUT_DOWN);

    int amount() { return value; }

    private Item(Category cat){ this.cat = cat; }
    public Item(Category cat, int value) {
        this.cat = cat;
        this.value = value;
    }
    public static Category categorize(Item item) { return item.cat; }
    public void setAmount(int newValue) { value = newValue; }
    public void setName(String name) { this.name = name; }
    @Override
    public String toString() {
        return name == null ? "Category: " + cat + " Value: " + value :
                "Category: " + cat + " Value: " + value + " Name: " + name;
    }
}

