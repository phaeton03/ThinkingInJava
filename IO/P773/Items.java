package ThinkingInJava.IO.P773;

import java.util.*;

import static ThinkingInJava.IO.P773.Item.*;
import static ThinkingInJava.IO.P773.Item.Category.ITEM_SELECTION;

public class Items {
    private Random random = new Random();
    private HashMap<String, Item> items = new HashMap<>();
    {
        addItem("Nickel", NICKEL);
        addItem("Dime", DIME);
        addItem("Quarter", QUARTER);
        addItem("Dollar", DOLLAR);
        addItem("ABORT_TRANSACTION", ABORT_TRANSACTION);
        addItem("STOP", STOP);
        addItem("ToothPaste", ITEM_SELECTION,75);
        addItem("Chips", ITEM_SELECTION,75);
        addItem("Sode", ITEM_SELECTION,100);
        addItem("Soap", ITEM_SELECTION, 50);
    }
    public void addItem(String name, Item.Category cat, int value) {
        items.put(name, new Item(cat, value));
        items.get(name).setName(name);
    }
    public void addItem(String name, Item item) {
        items.put(name, item);
        items.get(name).setName(name);
    }
    public Item getItem(String key) {
        return items.get(key);
    }
    public void clear() { items = new HashMap<>(); }
    public void initialize(ArrayList<String> list) {
        for(int i = 0; i <= list.size() - 3; i = i + 3)
            addItem(list.get(i),
                    Enum.valueOf(Item.Category.class, list.get(i+1)),
                    Integer.parseInt(list.get(i + 2).trim()));
    }
    public Iterator<Map.Entry<String,Item>> itemIterator() {
        return items.entrySet().iterator();
    }
    public Item randomSelection() {
        ArrayList<Item> values = new ArrayList<>(items.values());
        return values.get(random.nextInt(values.size())); }
}
