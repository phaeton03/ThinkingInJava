package ThinkingInJava.IO.P773;

import static ThinkingInJava.IO.P773.VendingMachine2.State.*;

public class RestingNext extends Command{
    public RestingNext(VendingMachine2 vm2) {
        super(vm2);
    }
    @Override
    public void next(Input input) {
        switch(Category.categorize(input)) {
            case MONEY:
                vm2.amount += input.amount();
                vm2.state = ADDING_MONEY;
                break;
            case SHUT_DOWN:
                vm2.state = TERMINAL;
            default:
        }
    }
}
