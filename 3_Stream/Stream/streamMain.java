package Chapter3.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamMain {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("woonsik0");
        names.add("woonsik1");
        names.add("woonsik2");
        names.add("woonsik3");
        names.add("Koonsik");
        names.add("Koonsik1");
        names.add("Moonsik");

        //stream은 값을 갖고있는것이 아닌 데이터를 가지고 처리를 하는 것
        // 하나의 컨베이어 벨트에 데이터를 하나씩 쭉 흘려보내면서 처리를 하는 개념/
        // 데이터를 담고있는 저장소 개념이 아니다
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        //스트림을 사용해도 기존 데이터의 값은 변하지 않는다
//        names.forEach(System.out::println);
//        System.out.println("----------");
//        stringStream.forEach(System.out::println);

        //무제한으로 지속적으로 들어오는 값에 대해 스트림으로 받아서 처리할수도 있다
        // Short Circuit 메소드를 사용해서 제한할수 있다


        Stream<String> stringStream1 = names.stream().map(String::toLowerCase);

        // 여기서 출력 sysout은 실행되지 않는다
        // 중계형 operator는 종료형 operator가 오기 전까지 실행되지 않는다
        // 그냥 선언만 되있는 것이다
        // 0~다수개의 중계operation과 한개의 종료operation으로 구성된다
        /*List<String> list = */names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        })/*.collect(Collectors.toList())*/;

        //list.forEach(System.out::println);

        System.out.println("============");

        //names.forEach(System.out::println);


        // 스트림에서 병렬적인 처리 - 항상 더 빠른것이 아니다 (직접 적용해보고 확인해야한다)
        List<String> list = names.parallelStream().map(String::toLowerCase)
                .collect(Collectors.toList());

        List<String> list1 = names.parallelStream().map((s) -> {
            //출력되는 쓰레드가 모두 다른것을 볼수 있다 (병렬적인 처리)
            System.out.println(s + " "+ Thread.currentThread().getName());
            return  s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println("======");
        list.forEach(System.out::println);
        System.out.println("======");
        list1.forEach(System.out::println);


    }
}
