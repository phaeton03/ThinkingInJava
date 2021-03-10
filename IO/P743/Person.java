package ThinkingInJava.IO.P743;
//Exercise 31: (2) Add appropriate address information to Person.java and People.java.
import java.io.*;
import java.util.*;
import nu.xom.*;

public class Person extends ArrayList<Person> {
    private String first, last, address;
    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }
    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        Element address = new Element("address");
        lastName.appendChild(last);
        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(address);
        return person;
    }
    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        address = person.getFirstChildElement("address").getValue();
    }
    public String toString() { return first + " " + last + " " + address; }
    public static void format(OutputStream os, Document doc) throws Exception {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(new Person("Dr Bunsen", "HoneyDew", "Mars lvl 11"),
                new Person("Gonzo", "The Great", "World Galaxic Station section 17"),
                new Person("Philip J.", "Fry", "planet Earth, USA, New York, sector 17"));
        System.out.println(people);
        Element root = new Element("people");
        for(Person p : people)
            root.appendChild(p.getXML());
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream("People.xml")), doc);
    }
}
