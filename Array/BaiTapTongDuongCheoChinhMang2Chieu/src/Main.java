import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Nhập phần tử " + i + " cột " + j + " : ");
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int[] sum = {0,0};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == j){
                    sum[0] += arr[i][j];
                }
                if(i+j == arr.length - 1) {
                    sum[1] += arr[i][j];
                }
            }
        }
        System.out.println(Arrays.toString(sum));

    }
}