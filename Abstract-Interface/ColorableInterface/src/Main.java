public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Rectangle(4,5);
        shapes[2] = new Square(10);

        for (Shape item : shapes) {
            System.out.println(item.toString());
            if(item instanceof Square) ((Square) item).howToColor();
        }
    }
}