package test;

import student.Student;

public class Test extends Student {
    public static void main(String[] args) {
//        Test protected
        Test test = new Test();
        Student student = new Student();
        test.setName("Test protected");
        System.out.print(test);
    }
}
