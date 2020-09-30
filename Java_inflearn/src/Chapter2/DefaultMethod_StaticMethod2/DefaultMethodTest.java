package Chapter2.DefaultMethod_StaticMethod2;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DefaultMethodTest {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("woonsik0");
        names.add("woonsik1");
        names.add("woonsik2");
        names.add("woonsik3");
        names.add("Koonsik");
        names.add("Koonsik1");
        names.add("Moonsik");
        //names.add("woonsik4");
        //names.add("woonsik5");


        names.forEach(System.out::println);
        names.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("========");

        // Spliterator
        // iterator와 비슷한데 쪼갤수 있는 기능이 있다
        // 순환이 가능
        Spliterator<String> split = names.spliterator();
        //Spliterator<String> split1  = split.trySplit();
        // 순환하는 split를 최대한 반으로 쪼갠다

        while (split.tryAdvance(System.out::println));
        System.out.println("========");
        //while (split1.tryAdvance(System.out::println));

        names.removeIf(s->s.startsWith("M"));

        //문자열 순서로 정렬
        names.sort(String::compareToIgnoreCase);
        //반대로 정렬
        Comparator<String> comparator = String::compareToIgnoreCase;
        names.sort(comparator.reversed());

        //추가적인 정렬을 원하는 경우
        names.sort(comparator.reversed().thenComparing(s-> s.lastIndexOf(s)));


        //java버전 업데이트 후 API를 제공하는 라이브러리에 변화가 발생하였다

        //스트림 활용
        List<String> list = names.stream().map(String::toUpperCase)
                .filter(s-> s.startsWith("K"))
                .collect(Collectors.toList());
        Spliterator<String> stringSpliterator = list.spliterator();
        while(stringSpliterator.tryAdvance(System.out::println));
    }
}
