package ThinkingInJava.IO.P773;

public abstract class Command {
     VendingMachine2 vm2;
     public Command(VendingMachine2 vm2) {
          this.vm2 = vm2;
     }
     void next(Input input) {
          throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
     }
     void next() {
          throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
     }
     void output() { System.out.println(vm2.amount); }
}
