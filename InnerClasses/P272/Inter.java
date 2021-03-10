package ThinkingInJava.InnerClasses.P272;

public interface Inter {
    Inter getInstance();
    class Inner implements Inter{
        public Inter getInstance(){
            class DeepInner implements Inter{
                @Override
                public Inter getInstance() {
                    return null;
                }
            }

            return new DeepInner();
        }
    }
}
