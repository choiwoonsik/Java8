package Chapter1.Lambda;

import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        LambdaTest.run();

        Supplier<Integer> get10 = () -> {
            //body부분 한줄인 경우 생략이 가능
            return 10;
        };

        //생략한 경우
        Supplier<Integer> get20 = () -> 10;

        //3개의 인자의 타입이 같은 경우 사용하는 binaryOperator
        BinaryOperator<Integer> get30 = (a, b) -> a + b;
    }
        //변수 캡쳐
    private static void run() {
        //사실상 final (effective final) 더이상 변경되지 않는 변수
        // effective final 일 경우에만 람다, 로컬클래스, 익명클래스에서 참조가 가능하다
        int basenumber = 10;

        // 로컬 클래스 -> 쉐도잉 가능
        // 개별 scope을 가지므로
        class localClass {
            void printBaseNumber() {
                int basenumber = 11;
                System.out.println(basenumber);
            }
        }
        localClass local = new localClass();
        local.printBaseNumber();

        // 익명 클래스잉 -> 쉐도잉 가능
        // 개별 scope을 가지므로
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override // 외부 변수를 현재 스코프 내 변수가 덮는다
            public void accept(Integer basenumber) {
                System.out.println(basenumber);
            }
        };
        integerConsumer.accept(10);

        // 람다 -> 쉐도잉 불가능
        // 현재 람다식이 존재하는 메서드와 scope가 동일하다
        IntConsumer printInt = (i) -> {
            //int basenumber; 동일 변수 선언 불가능
            System.out.println(i + basenumber);
        };

        printInt.accept(10);
    }
}
