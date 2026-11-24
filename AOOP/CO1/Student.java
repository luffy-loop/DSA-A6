public class Student {
    private String name;
    private long rollNo;

    Student(String name, long rollNo) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be null or blank");
        }

        if (rollNo < 0) {
            throw new IllegalArgumentException("Rollnumber cannot be zero");
        }

        this.name = name;
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }

    public static void main(String[] args) {
        Student s = new Student("K.Poojasri", 2510030093L);
        s.display();
    }
}