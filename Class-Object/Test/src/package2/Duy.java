package package2;

import package1.Abc;

public class Duy extends Abc{
//    public static void main(String[] args) {
//        Duy a = new Duy();
//        System.out.println(a.hours);
//        System.out.println(a.minutes);
//    }
    static int dk;
    public int abc() {
//        this.minutes; default khác package không truy cập
        return this.hours;  //khác package nhưng có kế thừa và là protected
    }
}
