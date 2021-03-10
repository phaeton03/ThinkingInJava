package ThinkingInJava.Generics.P518;

interface Payable<T>{}

class Employee implements Payable{}
class Hourly extends Employee implements Payable{}
public class MultipleInterfaceVariants {

}
