package ThinkingInJava.IO.P773;

import ThinkingInJava.Generics.P471.Generator;
import ThinkingInJava.Util.TextFile;

import java.util.*;
//Exercise 10: (7) Modify class VendingMachine (only) using EnumMap
// so that one program can have multiple instances of VendingMachine.

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;
    enum StateDuration { TRANSIENT }
    enum State {
        RESTING {
            void next(Input input) {
                switch(Category.categorize(input)) {
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
            void next(Input input) {
                switch(Category.categorize(input)) {
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
        void next(Input input) {
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
        }
        void output() { System.out.println(amount); }
    }
    static void run(Generator<Input> gen) {
        while(state != State.TERMINAL) {
            state.next(gen.next());
            while(state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        gen = new FileInputGenerator("VendingMachine.txt");
        run(gen);
    }
}
class RandomInputGenerator implements Generator<Input> {
    public Input next() { return Input.randomSelection(); }
}
class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;
    public FileInputGenerator(String fileName) {
        input = new TextFile(fileName, ";").iterator();
    }
    public Input next() {
        if(!input.hasNext())
            return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
