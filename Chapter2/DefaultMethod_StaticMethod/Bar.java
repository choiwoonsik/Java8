package Chapter2.DefaultMethod_StaticMethod;

public interface Bar {

    default void printNameUpperCase(){
        System.out.println("BAR");
    };
}
