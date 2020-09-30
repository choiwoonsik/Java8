package Chapter1.MethodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodTest {
    public static void main(String[] args) {
        //메소드 레퍼런스 사용하기 전
        UnaryOperator<String> hi = (s) -> "hi " + s;

        //Greeting이라는 클래스에서 스태틱 메서드를 사용하겠다 의 의미 ::
        // 콜론 두개가 찍혀있다면 메소드 레퍼런스
        // 스태틱 메소드를 사용하는 방법
        // 아래 한줄의 선언은 Greeting의 hi메소드를 UnaryOperator가
        // 참조하겠다는 의미 이후에 apply를 통해 사용
        UnaryOperator<String> hi_0 = Greeting::hi;
        System.out.println(hi_0.apply("byeori"));

        //greeting 인스턴스의 메서드를 사용하겠다 ::
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi_1 = greeting::hello;
        System.out.println(hi_1.apply("woonsik"));

        //생성자에 대한 메소드 레퍼런스 -> 입력값은 없고 반환값은 있는(타입 자기자체)
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1  = newGreeting.get();

        //입력값을 받는 생성자에 대한 메소드 레퍼런스
        Function<String, Greeting> woonGreeting = Greeting::new;
        Greeting woon = woonGreeting.apply("woonsik");
        System.out.println(woon.getName());

        //특정타입의 불특정 다수의 인스턴스의 메서드 참조하는 법
        String[] names = {"wchoi", "dnstlr", "choi"};

        //기존 사용하던 함수형 인터페이스의 추상메서드사용
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == o2)
                    return 1;
                else
                    return 0;
            }
        });

        //추상메서드이므로 람다식 적용 가능 , 아래와 같이 변환이 가능
        Arrays.sort(names, (o1, o2) -> {
            if (o1 == o2)
                return 1;
            else
                return 0;
        });

        // 다른 기존의 메소드를 참조할수도 있다
        //임의의 개의 인자들을 String의 compateToIgnoreCase라는 메서드를 사용하게 된다
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString((names)));
    }
}
