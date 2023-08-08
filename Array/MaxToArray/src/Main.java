import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if(size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element: " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Property list: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
                index = i + 1;
            }
        }
        System.out.println("\nThe largest property value in the list is " + max + ", at position " + index);
    }
}