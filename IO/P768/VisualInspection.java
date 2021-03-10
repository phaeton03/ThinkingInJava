package ThinkingInJava.IO.P768;

public class VisualInspection extends MailHandler {
    public VisualInspection(MailHandler mailHandler) { super(mailHandler); }
    @Override
    public boolean handle(Mail3 m) {
        switch (m.readability) {
            case ILLEGIBLE: return handleNext(m);
            default:
                switch(m.address) {
                    case INCORRECT: return handleNext(m);
                    default:
                        System.out.println("Delivering " + m + " normally");
                        return true;
                }
        }
    }
}
