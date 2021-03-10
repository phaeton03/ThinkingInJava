package ThinkingInJava.IO.P773;

import static ThinkingInJava.IO.P773.VendingMachine2.State.*;

public class AddingMoneyNext extends Command {
    public AddingMoneyNext(VendingMachine2 vm2) {
        super(vm2);
    }
    @Override
    void next(Input input) {
        switch(Category.categorize(input)) {
            case MONEY:
                vm2.amount += input.amount();
                break;
            case ITEM_SELECTION:
                vm2.selection = input;
                if(vm2.amount < vm2.selection.amount())
                    System.out.println("Insufficient money for " + vm2.selection);
                else vm2.state = DISPENSING;
                break;
            case QUIT_TRANSACTION:
                vm2.state = GIVING_CHANGE;
                break;
            case SHUT_DOWN:
                vm2.state = TERMINAL;
            default:
        }
    }
}
