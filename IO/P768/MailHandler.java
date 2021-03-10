package ThinkingInJava.IO.P768;

public abstract class MailHandler {
    MailHandler next;
    public abstract boolean handle(Mail3 m);
    public MailHandler(MailHandler next) {
        this.next = next;
    }
    public void setNext(MailHandler mailHandler) {
        next = mailHandler;
    }
    public boolean handleNext(Mail3 m) {
        if (next == null) return false;
         return next.handle(m);
    }
}
