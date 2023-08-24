package IllegalTriangleException;

import java.util.Scanner;

public class Main {

    static void triangle(int a, int b, int c) throws IllegalTriangleException {
        if(a < 0 || b < 0 || c < 0){
            throw new IllegalTriangleException("Canh khong duoc am");
        } else if(a + b < c || a + c < b || b + c < a) {
            throw new IllegalTriangleException("Ba canh khong cua tam giac");
        } else  {
            System.out.println("Dung");
        }
    }
//    private static void checkTriangle(int a, int b, int c){
//        try{
//            triangle(a,b,c);
//        } catch (IllegalTriangleException e) {
//            System.err.println(e.getMessage());
//        }
//    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        try{
            triangle(3,-5,4);
        } catch (IllegalTriangleException e) {
            System.err.println(e);
        }
//        System.out.println("aa");
//            int a = scanner.nextInt();
//            System.out.println("aa");
//            int b = scanner.nextInt();
//            System.out.println("aa");
//            int c = scanner.nextInt();
//
//        checkTriangle(a,b,c);
    }
}
