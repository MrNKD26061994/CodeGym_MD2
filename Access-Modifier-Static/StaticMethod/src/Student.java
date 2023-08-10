public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    Student(int r, String n) {
        rollno = r;
        name = n;
    }
    static void change() {
        if(college.equals("BBDIT")) {
            college = "CODEGYM";
        } else {
            college = "BBDIT";
        }
    }
    void display() {
        System.out.print(rollno + " " + name + " " + college + "\n");
    }
}
