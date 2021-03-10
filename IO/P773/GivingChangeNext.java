package ThinkingInJava.IO.P773;

import static ThinkingInJava.IO.P773.VendingMachine2.State.RESTING;

public class GivingChangeNext extends Command {
    public GivingChangeNext(VendingMachine2 vm2) {
        super(vm2);
    }

    @Override
    void next() {
        if(vm2.amount > 0) {
            System.out.println("Your change: " + vm2.amount);
            vm2.amount = 0;
        }
        vm2.state = RESTING;
    }
}

