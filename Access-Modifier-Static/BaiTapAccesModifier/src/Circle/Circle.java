package Circle;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
    }

//    public double getRadius() {
//        return this.radius;
//    }

//    private double getRadius() {
//        return this.radius;
//    }
//    double getRadius() {
//        return this.radius;
//    }
    protected double getRadius() {
        return this.radius;
    }

    double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
}
