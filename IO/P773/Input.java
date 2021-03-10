package ThinkingInJava.IO.P773;

import java.util.*;

import static ThinkingInJava.IO.P773.Input.*;

public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value;
    Input(int value) { this.value = value; }
    Input() {}
    int amount() { return value; }
    static Random random = new Random();
    public static Input randomSelection() {
        return values()[random.nextInt(values().length)];
    }
}

enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;
    Category(Input... values) { this.values = values; }
    private static EnumMap<Input, Category> categories =
            new EnumMap<Input, Category>(Input.class);
    static {
        for(Category c : Category.class.getEnumConstants())
            for(Input type : c.values)
                categories.put(type, c);
    }
    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
