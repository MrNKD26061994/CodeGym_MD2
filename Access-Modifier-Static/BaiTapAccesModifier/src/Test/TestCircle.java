package Test;

import Circle.Circle;

public class TestCircle extends Circle{
    public static void main(String[] args) {
//        Test protected khác package
        TestCircle testCircle = new TestCircle();
        System.out.print(testCircle.getRadius());

//        Test default khác package
//        Circle c = new Circle(104);
//        c.getRadius();
    }
}
