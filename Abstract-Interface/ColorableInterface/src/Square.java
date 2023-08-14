public class Square extends Rectangle implements Colorable{
    public Square() {
        super();
    }
    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super("Blue", true, side, side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
    }

    @Override
    public String toString() {
        return "A Square with side = " + getWidth() + "A Shape width color of " + color + " and filled/not " + filled + '.' + " Area = " + this.getArea() + " Perimeter = " + this.getPerimeter();
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
