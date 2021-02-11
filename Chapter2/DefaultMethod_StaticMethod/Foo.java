package Chapter2.DefaultMethod_StaticMethod;

public interface Foo {

    void printName();

    // Foo 인터페이스를 상속받은 모든 클래스들은
    // 디폴트 메서드를 사용할 수 있다
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();
}
