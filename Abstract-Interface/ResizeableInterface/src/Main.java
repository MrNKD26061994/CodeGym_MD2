public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Rectangle(3, 5);

        System.out.println("Pre-up");
        for (Shape item : shapes) {
            System.out.println(item);
        }

        System.out.println("After-up");
        for (Shape item : shapes) {
            item.resize(3);
            System.out.println(item);
        }
    }
}