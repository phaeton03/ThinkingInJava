package ThinkingInJava.IO.P768;

import ThinkingInJava.Util.Enums;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.*;
//Exercise 9: (5) Modify class PostOffice so that it uses an EnumMap.
class Mail2 {
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
    public static Mail2 randomMail() {
        Mail2 m = new Mail2();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }
    public static Iterable<Mail2> generator(final int count) {
        return new Iterable<Mail2>() {
            int n = count;
            public Iterator<Mail2> iterator() {
                return new Iterator<Mail2>() {
                    public boolean hasNext() { return n-- > 0; }
                    public Mail2 next() { return randomMail(); }
                    public void remove() { throw new UnsupportedOperationException(); }
                };
            }
        };
    }
}

public class PostOffice2 {
    static EnumMap<MailHandler, Command> em = new EnumMap<>(MailHandler.class);
    static {
        em.put(MailHandler.GENERAL_DELIVERY, new Command() {
            @Override
            public boolean handle(Mail3 m) {
                        switch(m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default: return false;
                }
            }
        });
        em.put(MailHandler.MACHINE_SCAN, new Command() {
            @Override
            public boolean handle(Mail3 m) {
                switch (m.scannability) {
                    case UNSCANNABLE: return false;
                    default:
                        switch(m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
            }
        }
    }
        });
        em.put(MailHandler.VISUAL_INSPECTION, new Command() {
            @Override
            public boolean handle(Mail3 m) {
                switch (m.readability) {
                    case ILLEGIBLE: return false;
                    default:
                        switch(m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.RETURN_TO_SENDER, new Command() {
            @Override
            public boolean handle(Mail3 m) {
                switch(m.returnAddress) {
                    case MISSING: return false;
                    default:
                        System.out.println("Returning " + m + " to sender");
                        return true;
                }
            }
        });
    }
    enum MailHandler {
        GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER;
    }
    static void handle(Mail3 m) {
        for(Map.Entry<MailHandler, Command> pair : em.entrySet())
            if(pair.getValue().handle(m)) return;
        System.out.println(m + " is a dead letter");
    }

    public static void main(String[] args) {
        for(Mail3 mail : Mail3.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*****");
        }
    }
}
