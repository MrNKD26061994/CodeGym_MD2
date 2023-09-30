package utils;

import java.util.Scanner;

public class MyScanner {
    static Scanner scanner;
    public MyScanner() {}
    public static Scanner scannerInstance() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
