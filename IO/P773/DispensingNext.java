package ThinkingInJava.IO.P773;

import static ThinkingInJava.IO.P773.VendingMachine2.State.*;

public class DispensingNext extends Command {
    public DispensingNext(VendingMachine2 vm2) {
        super(vm2);
    }
    @Override
    void next() {
        System.out.println("here is your " + vm2.selection);
        vm2.amount -= vm2.selection.amount();
        vm2.state = GIVING_CHANGE;
    }
}
