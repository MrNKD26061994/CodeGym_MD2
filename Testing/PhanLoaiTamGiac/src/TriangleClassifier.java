public class TriangleClassifier {
    private int a, b, c;

    public TriangleClassifier(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String classify() {
        if(checkTriangle(a, b, c)){
            if(checkEquilateralTriangle(a,b,c)) {
                return "tam giác đều";
            } else if(checkIsoscelesTriangle(a,b,c)) {
                return "tam giác cân";
            } else if(checkSquareTriangle(a,b,c)) {
                return "tam giác vuông";
            } else {
                return "tam giác thường";
            }
        } else {
            return "không phải là tam giác";
        }
    }

    public boolean checkTriangle(int a, int b, int c) {
        if(a + b > c && a + c > b && b + c > a) {
            return true;
        }
        return false;
    }

    public boolean checkIsoscelesTriangle(int a, int b, int c) {
        if (a == b || a == c || b == c) {
            return true;
        }
        return false;
    }
    public boolean checkEquilateralTriangle(int a, int b, int c) {
        if (a == b && a == c) {
            return true;
        }
        return false;
    }
    public boolean checkSquareTriangle(int a, int b, int c) {
        if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a) {
            return true;
        }
        return false;
    }


}
