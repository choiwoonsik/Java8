package Chapter3.Stream2;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        List<String> collect = names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("spring 으로 시작하는 수업");
        // TODO
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("close 되지 않은 수업");
        // TODO
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO
        springClasses.stream()
            // map에서 string으로 형변환된다
                .map(OnlineClass::getTitle)
            //즉 forEach에 들어갈때는 String 타입
                .forEach(System.out::println);


        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // TODO
        // flat Map == 모두 꺼내서 풀어서 나열
        // 리스트로 이뤄진 리스트 keesun을 모두 까서 하나의 리스트로 만든다
        // (각 값들은 OnlineCalss 타입)
        keesunEvents.stream().flatMap(list -> list.stream())
                            .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // TODO
        Stream.iterate(10, i -> i + 1)
                    .skip(10)
                    .limit(5)
                    .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        // TODO
        javaClasses.stream()
                .filter(oc -> oc.getTitle().contains("Test"))
                .forEach(oc -> System.out.println(oc.getTitle()));

        boolean Test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(Test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        // TODO
        List<String> springList = springClasses.stream()
                .filter(sc -> sc.getTitle().contains("spring"))
                .map(sc -> sc.getTitle())
                .collect(Collectors.toList());
        springList.forEach(System.out::println);
    }
}