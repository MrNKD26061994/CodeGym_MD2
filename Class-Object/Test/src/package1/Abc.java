package package1;

public class Abc {
    protected int hours = 3; // có thể truy cập lớp cha ngoài package
    int minutes = 5; //default chỉ có thể truy cập trong package
    private int a; //private truy cập trong nội bộ class

    public static int b;
    public int getA(){
        return 1;
    } //truy cập thoải mái

}
