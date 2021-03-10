package ThinkingInJava.ContainersInDepth.P647;
//Exercise 31: (5) Create a container that encapsulates an array of String, and that only
//allows adding Strings and getting Strings, so that there are no casting issues during use. If
//the internal array isn’t big enough for the next add, your container should automatically
//resize it. In main( ), compare the performance of your container with an
//ArrayList<String>.

import ThinkingInJava.Arrays.P576.CountingGenerator;
import ThinkingInJava.Containers.P305.Generator;
import ThinkingInJava.Generics.P475.Generators;

import java.util.*;
class ListTester2 extends Tester<List<String>>{
    static List<Test<List<String>>> tests = new ArrayList<>();
    private static Random rand = new Random();
    static {
        tests.add(new Test<List<String>>("add"){
            @Override
            public int test(List<String> list, TestParam tp) {
                int loop = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loop; i++){
                    list.clear();
                for(int j = 0; j < size; j++)
                    list.add(j + "");
            }
            return loop * size;
          }
        });
        tests.add(new Test<List<String>>("get"){
            @Override
           public int test(List<String> cont, TestParam tp) {
                int loop = tp.loops;
                for(int i = 0; i < loop; i++)
                    cont.get(rand.nextInt(cont.size()));
                return loop;
            }
        });
    }

    public ListTester2(List<String> container, List<Test<List<String>>> tests) {
        super(container, tests);
    }
    @Override
    protected List<String> initialize(int size) {
        container.clear();
        Generators.fill(container, new CountingGenerator.String(3), size);
        return container;
    }
    public static void run(List<String> list, List<Test<List<String>>> tests){
        ListTester2 lt2 = new ListTester2(list, tests);
        lt2.setHeadLine("StringArrayList");
        lt2.timedTest();
    }
}
public class StringArrayList extends AbstractList<String> {
    private String[] stringArray;
    private final int CAP = 10;
    int index = 0;
    public StringArrayList() { stringArray = new String[CAP]; }
    public StringArrayList(int cap) {
        stringArray = new String[cap];
    }

    @Override
    public void clear() {
        index = 0;
        stringArray = new String[CAP];
    }

    @Override
    public boolean add(String s) {
        if(index >= stringArray.length){
            String[] buffer = stringArray;
            stringArray = new String[stringArray.length * 2];
            for(int i = 0; i < buffer.length; i++)
                stringArray[i] = buffer[i];
        }
        stringArray[index++] = s;
        return true;
    }
    @Override
    public String get(int index) {
        return stringArray[index];
    }
    @Override
    public int size() { return index; }

    public static void main(String[] args) {
          ArrayList<Integer> intList = new ArrayList<>();
          intList.add(90);
          intList.get(0);
          ListPerfomanceString.ListTester.run(new ArrayList<>(), ListPerfomanceString.tests);
          ListTester2.run(new StringArrayList(), ListTester2.tests);
    }
}
