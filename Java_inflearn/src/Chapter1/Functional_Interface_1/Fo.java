package Chapter1.Functional_Interface_1;

public class Fo {
    public static void main(String[] args) {
        // 익명 내부 클래스 == annoymous inner class
//        RunSomething run = new RunSomething() {
//            @Override
//            public void doIt() {
//              System.out.println("");
//            }
//        }

        //함수형 인터페이스를 구현할때 사용하는 람다식
        RunSomething runSomething = () -> System.out.println("test");
        RunSomething runSomething1 = () -> {
            System.out.println("this is interface");
            System.out.println("interface...!");
        };
        RunSomething runSomething2 = () -> {
            System.out.println("test");
            System.out.println("this is test");
        };

        //함수가 함수를 리턴하거나 함수가 매개변수로 받을수 있다면 -> 고차함수
        //자바에서 함수는 단순히 특수한 경우의 객체일뿐 결국 객체이다
    }
}
