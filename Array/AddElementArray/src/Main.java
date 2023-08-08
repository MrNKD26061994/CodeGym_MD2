import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10,4,6,7,8,0,0,0,0,0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị: ");
        int inputValue = scanner.nextInt();
        System.out.print("Nhập vị trí thêm: ");
        int index = scanner.nextInt();
        int temp = arr[index];
        arr[index] = inputValue;
        for (int i = index + 1; i < arr.length-1; i++) {
            arr[i] = temp;
            temp = arr[i+1];
        }
        System.out.println(Arrays.toString(arr));
    }
}