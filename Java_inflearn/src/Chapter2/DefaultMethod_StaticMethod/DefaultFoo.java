package Chapter2.DefaultMethod_StaticMethod;

public class DefaultFoo implements Foo, Bar{

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    // 두개의 인터페이스에서 중복돈 디폴트 메서드를 상속받는다면
    // 오버라이드를 해야만한다 (그렇지 않으면 컴파일에러 발생)
    //default Method도 재정의가 가능하다
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "my name is "+ this.name;
    }
}
