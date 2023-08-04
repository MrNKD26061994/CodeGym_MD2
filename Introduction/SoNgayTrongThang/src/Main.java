import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which month that you want to count days?");
        int month = scanner.nextInt();
        switch (month) {
            case 2 -> System.out.println("The month '2' has 28 or 29 days!");
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("The month '" + month + "' has 31 days!");
            case 4, 6, 9, 11 -> System.out.println("The month '" + month + "' has 30 days!");
            default -> System.out.println("Invalid input!");
        }
    }
}