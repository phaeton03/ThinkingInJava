package ThinkingInJava.IO.P768;

import ThinkingInJava.Util.Enums;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
//Exercise 10: (7) Modify class VendingMachine (only) using
// EnumMap so that one program can have multiple instances of VendingMachine.

class Mail3 {
    enum GeneralDelivery { YES, NO1, NO2, NO3, NO4, NO5 }
    enum Scannability { UNSCANNABLE, YES1, YES2, YES3, YES4 }
    enum Readability { ILLEGIBLE, YES1, YES2, YES3, YES4 }
    enum Address { INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6 }
    enum ReturnAddress { MISSING, OK1, OK2, OK3, OK4, OK5 }
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }
    public String details() {
        return toString() + ", General Delivery: " + generalDelivery +
                            ", Address Scanability: " + scannability +
                            ", Address Readability: " + readability +
                            ", Address Address: " + address +
                            ", Return address: " + returnAddress;
    }
    public static Mail3 randomMail() {
        Mail3 m = new Mail3();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }
    public static Iterable<Mail3> generator(final int count) {
        return new Iterable<Mail3>() {
            int n = count;
            public Iterator<Mail3> iterator() {
                return new Iterator<Mail3>() {
                    public boolean hasNext() { return n-- > 0; }
                    public Mail3 next() { return randomMail(); }
                    public void remove() { throw new UnsupportedOperationException(); }
                };
            }
        };
    }
}

public class PostOfficeProject3 {
    static MailHandler mailHandler;
    public static void setHandler(MailHandler mh) {
        mailHandler = mh;
    }
    public static void handle(Mail3 m) {
        if (mailHandler.handle(m)) return;
        System.out.println(m + " is a dead letter");
    }

    public static void main(String[] args) {
        MailHandler mailHandler = new GeneralDelivery(
                new MachineScan(new VisualInspection(new ReturnToSender(null))));
        setHandler(mailHandler);
        for(Mail3 mail : Mail3.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*****");
        }
    }
}
