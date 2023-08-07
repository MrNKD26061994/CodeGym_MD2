import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Print the rectangle:");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right):");
            System.out.println("3. Print isosceles triangle:");
            System.out.println("4. Exit:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    int a, b;
                    System.out.print("Nhâp chiều dài: ");
                    a = scanner.nextInt();
                    System.out.print("Nhập chiều rộng: ");
                    b = scanner.nextInt();
                    for (int i = 0; i < a; i++) {
                        for (int j = 0; j < b; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }
                case 2 -> {
                    System.out.println("1. botton left: ");
                    System.out.println("2. botton right: ");
                    System.out.println("3. top left: ");
                    System.out.println("4. top right: ");
                    int a = scanner.nextInt();
                    switch (a) {
                        case 1 -> {
                            System.out.print("Nhâp số cột: ");
                            int c = scanner.nextInt();
                            for (int i = 1; i <= c; i++) {
                                for (int j = 0; j < i; j++) {
                                    System.out.print("*");
                                }
                                System.out.println();
                            }
                        }
                        case 2 -> {
                            System.out.print("Nhâp số cột: ");
                            int c = scanner.nextInt();
                            for (int i = 1; i <= c; i++) {
                                for (int j = 1; j <= c; j++) {
                                    if(c < i + j){
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }
                                }
                                System.out.println();
                            }
                        }
                        case 3 -> {
                            System.out.print("Nhâp số cột: ");
                            int c = scanner.nextInt();
                            for (int i = 0; i < c; i++) {
                                for (int j = 5; j - i > 0 ; j--) {
                                    System.out.print("*");
                                }
                                System.out.println();
                            }
                        }
                        case 4 -> {
                            System.out.print("Nhâp số cột: ");
                            int c = scanner.nextInt();
                            for (int i = 0; i < c; i++) {
                                for (int j = c; j > 0; j--) {
                                    if(c - j >= i){
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }
                                }
                                System.out.println();
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Nhâp độ dài cạnh: ");
                    int c = scanner.nextInt();
                    for (int i = 1; i <= c; i++) {
//                        for (int j = 1; j <= c; j++) {
//                            if(c < i + j){
//                                System.out.print("*");
//                            } else {
//                                System.out.print(" ");
//                            }
//                        }
//                        for (int j = 2*c-2; j > c-1; j--) {
//                            if(2*c-1 - j >= i){
//                                System.out.print(" ");
//                            } else {
//                                System.out.print("*");
//                            }
//                        }
                        for (int j = 1; j < c + i; j++) {
                            if(j > c - i){
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                }
                case 0 -> System.out.println("Thank you!");
            }
        } while (choice != 4);
    }
}