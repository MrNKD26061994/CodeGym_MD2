import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10,4,6,7,8,4,0,0,0,0};
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        display(arr);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == input) {
                index = i;
                System.out.println("\nIndex " + input + " " + i);
                break;
            }
        }
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        display(arr);
    }

    public static void display(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}