package student;

public class Student {
    private String name;
    private String classes;

    public Student() {
        this.name = "John";
        this.classes = "C02";
    }
//    public void setName(String name) {
//        this.name = name;
//    }
    protected void setName(String name) {
        this.name = name;
    }
//    void setName(String name) {
//        this.name = name;
//    }
//    private void setName(String name) {
//        this.name = name;
//    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
