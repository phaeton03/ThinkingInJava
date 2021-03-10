package ThinkingInJava.IO.P768;

public class MachineScan extends MailHandler {
    public MachineScan(MailHandler next) {
        super(next);
    }
    @Override
    public boolean handle(Mail3 m) {
            switch (m.scannability) {
                case UNSCANNABLE: return handleNext(m);
                default:
                    switch(m.address) {
                        case INCORRECT: return handleNext(m);
                        default:
                            System.out.println("Delivering " + m + " automatically");
                            return true;
                    }
        }
    }
}
