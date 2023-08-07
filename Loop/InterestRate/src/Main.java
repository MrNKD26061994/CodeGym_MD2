import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        long money = scanner.nextLong();
        System.out.print("Enter number of months: ");
        byte month = scanner.nextByte();
        System.out.print("Enter annual interest rate in percentage: ");
        float interestRate = scanner.nextFloat();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate/100)/12;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}