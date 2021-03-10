package ThinkingInJava.Generics.P530;

import java.util.*;

interface Processor<T,Ef extends Exception, Es extends Exception>{
    void process(List<T> resultCollector) throws Ef,Es;
}
class ProcessRunner<T,Ef extends Exception, Es extends Exception>
        extends ArrayList<Processor<T,Ef,Es>>{
    public List<T> processAll() throws Ef,Es{
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T,Ef,Es> processor : this)
            processor.process(resultCollector);
        return resultCollector;
    }
}
class Failure1 extends Exception{}
class Failure2 extends Exception{}

class Processor1 implements Processor<String,Failure1,Failure2>{
    static int count = 3;
    public void process(List<String> resultCollector) throws Failure1, Failure2{
        Random random = new Random();
        if(count-- > 1) resultCollector.add("Yes");
        else resultCollector.add("No");
        if (count == 0) throw new Failure1();
        if (random.nextInt(count)*-1 == -1) throw new Failure2();
    }
}

class Processor2 implements Processor<Integer, Failure1, Failure2>{
    static int count = 2;
    public void process(List<Integer> resultCollector) throws Failure1, Failure2{
        if (count-- > 1) resultCollector.add(99);
        else resultCollector.add(0);
        if (count == 0) throw new Failure1();
        if (count < 0) throw new Failure2();
    }
}

public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String,Failure1,Failure2> prunner = new ProcessRunner<>();
        for (int i = 0; i < 2; i++)
            prunner.add(new Processor1());
        try {
            System.out.println(prunner.processAll());
        }catch(Failure1 e){
            System.err.println(e);
        }catch(Failure2 e){
            System.err.println(e);
        }
    }
}
