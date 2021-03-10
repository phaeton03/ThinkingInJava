package ThinkingInJava.typeinfo.P435;

import ThinkingInJava.typeinfo.P435.factory.Factory;

public class EgyptianMau extends Cat {
    public EgyptianMau(String name) {
        super(name);
    }
    public EgyptianMau() {
        super();
    }
    public static class Factory implements ThinkingInJava.typeinfo.P435.factory.Factory<EgyptianMau>{
        public EgyptianMau create(){
            return new EgyptianMau();
        }
    }
}
