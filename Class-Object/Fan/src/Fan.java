public class Fan {
    final private int SLOW = 1;
    final private int MEDIUM = 2;
    final private int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = this.SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public String toString() {
        if(this.on) {
            return "fan is on speed = " + this.speed + ", radius = " + this.radius + ", color = " + this.color;
        } else {
            return "fan is off";
        }
    }

//    public void toString()

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }
}
