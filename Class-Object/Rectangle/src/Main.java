import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();
        System.out.print("Enter the height: ");
        int height = scanner.nextInt();
        Rectangle rect = new Rectangle(width, height);
        System.out.println("Your Rectangle\n" + rect.display());
        System.out.println("Perimeter of the Rectangle: " + rect.getPerimeter());
        System.out.println("Area of the Rectangle: " + rect.getArea());
    }
}