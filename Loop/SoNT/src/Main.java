import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng số NT: ");
        int n = scanner.nextInt();
        int count;
        if(n < 0) {
            count = 0;
        } else if(n == 1) {
            System.out.print(2);
            count = 1;
        } else {
            System.out.print(2);
            count = 1;
            for (int i = 3; true; i++){
                boolean checkSNT = false;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if(i % j == 0) {
                        checkSNT = true;
                        break;
                    }
                }
                if (!checkSNT) {
                    System.out.print(" " + i);
                    count += 1;
                }
                if(count == n) {
                    break;
                }
            }
        }
    }
}