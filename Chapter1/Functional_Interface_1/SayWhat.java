package Chapter1.Functional_Interface_1;

public class SayWhat {
    public static void main(String[] args) {

        final int basenumber = 10;

        //함수형 인터페이스가 내부 변수를 변경하는 행위는 순수함수라 보기 힘들다
        //람다식으로 변경 불가능
        SayYes sayYes1 = new SayYes() {
            int basenumber = 10;
            @Override
            public int sayYes(int number) {
                basenumber++;
                return number + basenumber;
            }
        };
        System.out.println(sayYes1.sayYes(10));

        //함수형 인터페이스가 외부변수를 참조만 하는 경우 람다로 변경 가능
        //단 이때 참조의 경우 해당 변수가 final이라는 가정하에서 사용
        SayYes sayYes = number -> number + basenumber;
        System.out.println(sayYes.sayYes(10));

        //함수형 인터페이스로 인자와 매개변수로 int값을 가지는 경우
        SayYes sayYes2 = (number) -> {
            return number + 10;
        };

        SayYes sayYes3 = (number) -> {
            if (number%2 == 0)
                System.out.println("this is odd");
            else
                System.out.println("this is even");
            return number;
        };

        System.out.println(sayYes2.sayYes(10));
        System.out.println(sayYes3.sayYes(10));

        //basenumber++;
    }
}
