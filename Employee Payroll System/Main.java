import java.util.ArrayList;

// Abstract class representing an Employee
abstract class Employee {
    private String name;
    private int id;

    // Constructor for initializing name and id
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter for employee name
    public String getName() {
        return name;
    }

    // Getter for employee id
    public int getId() {
        return id;
    }

    // Abstract method to calculate salary (to be implemented by subclasses)
    public abstract double calculateSalary();

    // Override toString method to provide a string representation of the employee
    @Override
    public String toString() {
        return "Employee [name=" + name + ", id= " + id + ", salary=" + calculateSalary() + "]";
    }
}

// Full-time Employee subclass
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    // Constructor for FullTimeEmployee
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    // Override method to calculate salary for full-time employee
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Part-time Employee subclass
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    // Constructor for PartTimeEmployee
    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Override method to calculate salary for part-time employee
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// PayrollSystem class to manage employees
class PayrollSystem {
    private ArrayList<Employee> employeeList;

    // Constructor for PayrollSystem
    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    // Method to add an employee to the list
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Method to remove an employee based on their id
    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    // Method to display details of all employees
    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

// Main class to demonstrate the PayrollSystem
public class Main {
    public static void main(String[] args) {
        // Create a PayrollSystem object
        PayrollSystem payrollSystem = new PayrollSystem();

        // Create instances of FullTimeEmployee and PartTimeEmployee
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 10000.0);
        FullTimeEmployee emp2 = new FullTimeEmployee("Rakesh", 2, 10000.0);
        FullTimeEmployee emp3 = new FullTimeEmployee("Amit", 3, 10000.0);
        PartTimeEmployee emp4 = new PartTimeEmployee("Rohit", 4, 40, 200);

        // Add employees to the payroll system
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);

        // Display initial employee details
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();

        // Remove an employee and display the remaining employee details
        System.out.println("Remove an employee");
        payrollSystem.removeEmployee(4);
        System.out.println("Remaining employee details: ");
        payrollSystem.displayEmployees();
    }
}
