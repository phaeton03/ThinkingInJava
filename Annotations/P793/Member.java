package ThinkingInJava.Annotations.P793;

//Exercise 1: (2) Implement more SQL types in the database example.
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(40) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    @SQLBoolean Boolean isVIP = true;
    @SQLArray(size = 3) int[] arr = {4,5,5};
    String handle;
    static int memberCount;
    public String getHandle() { return handle; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String toString() { return handle; }
    public Integer getAge() { return age; }
    public Boolean getIsVIP() { return isVIP; }
    public int[] getArr() { return arr; }
}
