import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        System.out.print("Nhập số thứ nhất: ");
        a = scanner.nextInt();
        System.out.print("Nhập số thứ hai: ");
        b = scanner.nextInt();
        if(a == 0 || b == 0){
            System.out.println("No greatest common factor");
        } else {
            a = Math.abs(a);
            b = Math.abs(b);
            while (a != b) {
                if(a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.println("Greatest common factor: " + a);
        }
    }
}