package Chapter1.Functional_Interface_1;

public class checkNum {
    public static void main(String[] args) {
        IsInter isinter = new IsInter() {
            @Override
            public int isNum(int number) {
                return number + 10;
            };
        };

        IsInter isinter2 = new IsInter() {
            @Override
            public int isNum(int number) {
                if (number % 2 == 0){
                    System.out.println("is odd");
                }
                return number;
            };
        };

        System.out.println(isinter.isNum(5));
        System.out.println(isinter2.isNum(5));

        //람다식 적용 코드

        IsInter isinter3 = (number) -> number + 10;

        IsInter isinter4 = (number) -> {
            if (number % 2 == 0)
                System.out.println("this is odd");
            return number;
        };

        System.out.println(isinter3.isNum(5));
        System.out.println(isinter4.isNum(5));
    }
}
