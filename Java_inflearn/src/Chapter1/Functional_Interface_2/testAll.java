package Chapter1.Functional_Interface_2;

import java.util.function.*;

public class testAll {
    public static void main(String[] args) {

        //기존 생성자를 이용한 인스턴스 사용

        Plus10 plus10_2 = new Plus10();
        System.out.println(plus10_2.apply(10));

        //함수형 인터페이스 사용
        //UnaryOperator를 사용하여 표현 (함수의 인자값과 반환값이 같은경우 가능한 표현)
        UnaryOperator<Integer> minus10 = (i) -> i - 10;
        System.out.println(minus10.apply(5));

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(10));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(multiply2.apply(10));

        //+10 . compose ( * 2) : 곱하기 후 더하기 연산
        Function<Integer, Integer> mutiAndPlus10 = plus10.compose(multiply2);
        mutiAndPlus10.apply(10);

        Function<Integer, Integer> plusAndMulti = plus10.andThen(multiply2);
        plusAndMulti.apply(10);

        //BiFunction 두개의 인자를 받아서 하나의 반환값을 가지는 인터페이스 (단, 3개의 타입이 모두 다른경우)
        BiFunction<String, Character, Boolean> ohterSame = (s, c) -> {
            if (s.startsWith(c.toString()))
                return true;
            else
                return false;
        };

        //BinaryOperator 2개의 인자를 받고 하나의 반환값을 가지는 인터페이스 (단, 3개의 타입이 같은 경우)
        BinaryOperator<Integer> isSame = (num1, num2) -> {
            if (num1 == num2)
                return num1 + num2;
            else if (num1 > num2)
                return num1 * num2;
            else
                return 0;
        };

        // Consumer 하나의 인자만 받아고 반환값을 가지지 않는 인터페이스
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(5);

        // Supplier 인자값도 반환값도 없는 인터페이스
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        //Predicate 하나의 인자값에 대해서 boolean값으로만 반환하는 인터페이스
        Predicate<String> startWithWoon = (s) -> s.startsWith("woon");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

    }
}
