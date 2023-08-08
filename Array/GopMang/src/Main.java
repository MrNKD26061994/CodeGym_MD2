import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[4];
        int[] arr2 = new int[3];
        int[] arr3 = new int[arr1.length + arr2.length];
        System.out.println("Nhập phần tử cho mảng 1:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Nhập phần tử thứ: " + (i + 1) + ": ");
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Nhập phần tử cho mảng 2:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Nhập phần tử thứ: " + (i + 1) + ": ");
            arr2[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr3.length; i++) {
            if(i < arr1.length) {
                arr3[i] = arr1[i];
            } else {
                arr3[i] = arr2[i-arr1.length];
            }
        }
        System.out.println(Arrays.toString(arr3));
    }
}