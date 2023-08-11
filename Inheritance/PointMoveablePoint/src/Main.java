import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(4,4);
        System.out.println(point);
        System.out.println(Arrays.toString(point.getXY()));
        System.out.println();

        MoveablePoint moveablePoint = new MoveablePoint(5, 5, 8, 8);
        System.out.println(moveablePoint);
        System.out.println(Arrays.toString(moveablePoint.getSpeed()));
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}