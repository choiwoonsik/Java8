package Chapter1.Functional_Interface_1;

public class DoWork {
    public static void main(String[] args)
    {
        ComepleteShowInfo showInfo = new ComepleteShowInfo();
        showInfo.doIt();
        showInfo.endThis();
        showInfo.printAge();

        RunSomething run = () -> {
            System.out.println("print what?");
        };
    }
}
