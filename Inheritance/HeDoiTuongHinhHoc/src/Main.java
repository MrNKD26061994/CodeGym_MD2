public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(5.5);
        System.out.println(circle);
        circle = new Circle("blue", true, 6.6);
        System.out.println(circle);
        System.out.println();

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(6.6, 8.6);
        System.out.println(rectangle);
        rectangle = new Rectangle("red", true, 6.8, 8.6);
        System.out.println(rectangle);
        System.out.println();

        Square square = new Square();
        System.out.println(square);
        square = new Square(10.5);
        System.out.println(square);
        square = new Square("orange", true, 15.5);
        System.out.println(square);
    }
}