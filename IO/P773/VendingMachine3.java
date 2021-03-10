package ThinkingInJava.IO.P773;

import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Util.TextFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
//Exercise 11: (7) In a real vending machine you will want
// to easily add and change the type of vended items, so
// the limits imposed by an enum on Input are impractical
// (remember that enums are for a restricted set of types).
// Modify VendingMachine.java so that the vended items are
// represented by a class instead of being part of Input,
// and initialize an Array List of these objects from a
// text file (using net.mindview.util.TextFile).

public class VendingMachine3 {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Item selection = null;
    enum StateDuration { TRANSIENT }
    enum State {
        RESTING {
            void next(Item input) {
                switch(Item.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            void next(Item input) {
                switch(Item.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if(amount < selection.amount())
                            System.out.println("Insufficient money for " + selection);
                        else state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if(amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL { void output() {
            System.out.println("Halted");
            }
        };
        private boolean isTransient = false;
        State() {}
        State(StateDuration trans) { isTransient = true; }
        void next(Item input) {
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
        }
        void output() { System.out.println(amount); }
    }
    static void run(Generator<Item> gen) {
        while(state != State.TERMINAL) {
            state.next(gen.next());
            while(state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {
        Items items = new Items();
        //Generator<Item> gen = new RandomItemGenerator3(items);
        Generator<Item> gen = new FileItemGenerator3("VendingItems2.txt", items);
        run(gen);
    }
}

class RandomItemGenerator3 implements Generator<Item> {
    Items items;
    public RandomItemGenerator3(Items items) {
        this.items = items;
    }
    public Item next() { return items.randomSelection(); }
}

class FileItemGenerator3 implements Generator<Item> {
    private Iterator<Map.Entry<String,Item>> input;
    Items items;
    public FileItemGenerator3(String fileName, Items items) {
        this.items = items;
        ArrayList<String> args = new TextFile(fileName,"\\s");
        System.out.println(args);
        System.out.println("size" + args.size());
        items.initialize(args);
        input = items.itemIterator();
    }
    public Item next() {
        if(!input.hasNext())
            return null;
        return items.randomSelection();
    }
}
