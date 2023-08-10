public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Duy");
        student.display();
        Student.change();
        student.display();
        Student.change();
        student.display();
    }
}