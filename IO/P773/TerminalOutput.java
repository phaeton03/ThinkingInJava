package ThinkingInJava.IO.P773;

public class TerminalOutput extends Command {
    public TerminalOutput(VendingMachine2 vm2) {
        super(vm2);
    }
    @Override
    void output() { System.out.println("Halted"); }
}
