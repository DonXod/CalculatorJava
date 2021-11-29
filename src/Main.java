import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(Calculator.calculate(scanner.nextLine()));
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }
}
