
public class Employee {

    private final int empID;
    private String empName;
    private double salary;

    // Constructor
    Employee(int empID, String empName, double salary) {

        if (empID <= 0) {
            throw new IllegalArgumentException("Employee ID must be positive");
        }

        if (empName == null || empName.isBlank()) {
            throw new IllegalArgumentException("Employee name cannot be null or blank");
        }

        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }

        this.empID = empID;
        this.empName = empName;
        this.salary = salary;
    }

    // Update salary
    void updateSalary(double salary) {

        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }

        this.salary = salary;
    }

    // Get salary
    double getSalary() {
        return salary;
    }

    // Display employee details
    void display() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Salary: " + salary);
    }

    // Main method
    public static void main(String[] args) {

        Employee e = new Employee(101, "K.Poojasri", 30000);

        e.display();

        System.out.println("\nAfter Salary Update:");

        e.updateSalary(35000);

        e.display();
    }
}
