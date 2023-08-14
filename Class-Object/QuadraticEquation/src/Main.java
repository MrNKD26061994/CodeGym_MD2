import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        System.out.print("Enter a: ");
        a = scanner.nextDouble();
        System.out.print("Enter b: ");
        b = scanner.nextDouble();
        System.out.print("Enter c: ");
        c = scanner.nextDouble();
        QuadraticEquation pt2 = new QuadraticEquation(a, b, c);


        if(a == 0) {
            if(b == 0){
                if(c == 0) {
                    System.out.println("The equation has infinitely many solutions");
                } else {
                    System.out.println("The equation has no real roots");
                }
            } else {
                System.out.println("The equation has one root " + -c/b);
            }
        } else {
            if(pt2.getDiscriminant() == 0){
                System.out.println("The equation has one root " + pt2.getRoot1());
            } else if (pt2.getDiscriminant() > 0) {
                System.out.println("The equation has two roots " + pt2.getRoot1() + " and " + pt2.getRoot2());
            } else {
                System.out.println("The equation has no real roots");
            }
        }
    }

}