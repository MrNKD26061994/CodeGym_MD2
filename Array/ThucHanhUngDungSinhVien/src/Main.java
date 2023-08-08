import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if(size > 30) {
                System.out.println("Size should not exceed 30");
            }
        } while (size > 30);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        int count = 0;
        for (int item : array) {
            System.out.print(item + "\t");
            if (item >= 5 && item <= 10) {
                count += 1;
            }
        }
        System.out.println("\nThe number of students passing the exam is " + count);
    }
}