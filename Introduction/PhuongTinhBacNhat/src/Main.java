import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b;
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b', please enter constants:");
        System.out.print("Nhâp a: ");
        a = scanner.nextDouble();
        System.out.print("Nhâp b: ");
        b = scanner.nextDouble();
        if(a != 0) {
            double answer = b / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if(b == 0) {
                System.out.println("The solution is all x!");
            } else {
                System.out.println("No solution!");
            }
        }
    }
}