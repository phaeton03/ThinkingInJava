package ThinkingInJava.IO.P768;

public class GeneralDelivery extends MailHandler {
    public GeneralDelivery(MailHandler next) {
        super(next);
    }
    @Override
    public boolean handle(Mail3 m) {
            switch(m.generalDelivery) {
                case YES:
                    System.out.println("Using general delivery for " + m);
                    return true;
                default: return handleNext(m);
        }
    }
}
