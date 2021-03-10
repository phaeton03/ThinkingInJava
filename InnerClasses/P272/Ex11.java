package ThinkingInJava.InnerClasses.P272;

public class Ex11 {
    private class Inner implements Inter {
        @Override
        public Inter getInstance() {
            return null;
        }
    }

    public Inter getInstanceOfInnerClass() {
        return new Inner();
    }

    public Inter getInstance2(boolean t) {
        if (t) {
            class DeepInner implements Inter {
                public DeepInner(){
                    System.out.println("DeepInner created");
                }
                @Override
                public Inter getInstance() {
                    return null;
                }
            }
            return new DeepInner();
        } else return null;
    }


    public static void main(String[] args) {
        Ex11 ex11 = new Ex11();
        Inter deepInner = ex11.getInstance2(true);
        Inter inner = ex11.getInstanceOfInnerClass();
    }
}
