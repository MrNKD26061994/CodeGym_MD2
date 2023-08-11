public class Cylinder extends Circle{
    private int height;

    public Cylinder() {}

    public Cylinder(double radius, String color, int height) {
        super(radius, color);
        this.height = height;
    }

    @Override
    public double getArea() {
        return super.getPerimeter() * this.height;
    }

    public double getAreaAll() {
        return this.getArea() + super.getArea() * 2;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}' + " Area = " + getArea() + " AreaAll = " + getAreaAll() + " Volume = " + getVolume();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
