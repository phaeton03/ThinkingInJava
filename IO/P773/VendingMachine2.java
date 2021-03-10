package ThinkingInJava.IO.P773;

import java.util.*;
import ThinkingInJava.Generics.P471.Generator;
//Exercise 10: (7) Modify class VendingMachine (only) using EnumMap
// so that one program can have multiple instances of VendingMachine.

public class VendingMachine2 {
    public State state = State.RESTING;
    public int amount = 0;
    public Input selection = null;
    enum StateDuration { TRANSIENT }
     EnumMap<State, Command> enumMap = new EnumMap<State, Command>(State.class);
     {
        enumMap.put(State.RESTING, new RestingNext(this));
        enumMap.put(State.ADDING_MONEY, new AddingMoneyNext(this));
        enumMap.put(State.DISPENSING, new DispensingNext(this));
        enumMap.put(State.GIVING_CHANGE, new GivingChangeNext(this));
        enumMap.put(State.TERMINAL, new TerminalOutput(this));
    }
    public enum State {
        RESTING,
        ADDING_MONEY,
        DISPENSING(StateDuration.TRANSIENT),
        GIVING_CHANGE(StateDuration.TRANSIENT),
        TERMINAL;
        private boolean isTransient = false;
        State() {}
        State(StateDuration trans) { isTransient = true; }
    }
     void run(Generator<Input> gen) {
        while(state != State.TERMINAL) {
            enumMap.get(state).next(gen.next());
            while(state.isTransient)
                enumMap.get(state).next();
            enumMap.get(state).output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        Generator<Input> gen2 = new FileInputGenerator("VendingMachine.txt");
        new VendingMachine2().run(gen);
        System.out.println("****************************");
        new VendingMachine2().run(gen2);
    }
}

