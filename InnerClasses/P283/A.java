package ThinkingInJava.InnerClasses.P283;

public class A {
    public U u(){
        return new U(){
            public void end(){
                System.out.println(A.this.getClass() + " end");
            }

            @Override
            public void next() {
                System.out.println(A.this.getClass() + " next");
            }

            @Override
            public void previous() {
                System.out.println(getClass() + " previous");
            }
        };
    }
}
