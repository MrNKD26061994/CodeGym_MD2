import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        System.out.print("Nhập số $: ");
        int dola = scanner.nextInt();
        System.out.printf("%d%s%d%s", dola, "& quy đổi thành: ", dola*rate, "VND");
    }
}