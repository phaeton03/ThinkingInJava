package ThinkingInJava.IO.P768;

public class ReturnToSender extends MailHandler {
    public ReturnToSender(MailHandler mailHandler) {
        super(mailHandler);
    }
    @Override
    public boolean handle(Mail3 m) {
        switch(m.returnAddress) {
            case MISSING: return handleNext(m);
            default:
                System.out.println("Returning " + m + " to sender");
                return true;
        }
    }
}
