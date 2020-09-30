package Chapter1.Functional_Interface_1;

//함수형 인터페이스라면 @FunctionalInteface 애노테이션을 달아주자
@FunctionalInterface
public interface RunSomething {

    //추상 메서드가 하나만 있으면 함수형 인터페이스
    abstract void doIt();

    // 추상 메서드가 두개 이상 있는순간 함수형 인터페이스가 아니다
    //abstract void doThis();
    //abstract void doItAgain();

    //인터페이스임에도 스태틱 메서드를 정의할수 있다
    static void printName() {
        System.out.println("myName");
    }

    default void printAge(){
        System.out.println("26");
    }

}
