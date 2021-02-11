package Chapter2.DefaultMethod_StaticMethod;

public class TestMain {
    public static void main(String[] args) {

        Foo foo = new DefaultFoo("woonsik");
        foo.printName();
        foo.printNameUpperCase(); // default Method


        //스태틱 메서드에 접근
        //해당 타입과 관련 헬터 또는 메소드를 제공할 때 인터페이스에
        //스태틱 메소드를 제공할 수 있다
        Foo.printAnything();

        System.out.println(foo.toString());
    }
}
