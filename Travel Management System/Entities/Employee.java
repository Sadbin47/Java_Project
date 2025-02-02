package Entities;

public class Employee extends Person {
    private double salary;
    private int workingTime;
    private int overTime;

    private static int employeeCounter = 0;

    public Employee(String id, String name, String email, double salary, int workingTime, int overTime) {
        super(id, name, email);
        this.salary = salary;
        this.workingTime = workingTime;
        this.overTime = overTime;
        employeeCounter++;
    }

    // Add missing constructor
    public Employee(String name, String id, double salary, int workingTime, int overTime) {
        super(id, name, "");
        this.salary = salary;
        this.workingTime = workingTime;
        this.overTime = overTime;
        employeeCounter++;
    }

    // Add default constructor
    public Employee() {
        super("", "", "");
    }

    // Add missing methods
    public String getEmployeeId() {
        return getId();
    }

    public String getEmployeeName() {
        return getName();
    }

    public void setEmployeeName(String name) {
        setName(name);
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public void setWorkingTime(int workingTime) {
        if (workingTime >= 0) {
            this.workingTime = workingTime;
        }
    }

    public void setOverTime(int overTime) {
        if (overTime >= 0) {
            this.overTime = overTime;
        }
    }

    public double getSalary() {
        return salary;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public int getOverTime() {
        return overTime;
    }

    public void showEmployeeInfo() {
        displayInfo();
    }

    @Override
    public void displayInfo() {
        System.out.println("-------------------------");
        System.out.println("Employee Name : " + getName());
        System.out.println("Employee ID : " + getId());
        System.out.println("Email : " + getEmail());
        System.out.println("Salary : " + salary);
        System.out.println("Working Time (hrs) : " + workingTime);
        System.out.println("Overtime (hrs) : " + overTime);
        System.out.println("-------------------------");
    }

    public String getEmployeeAsString() {
        return  "-------------------------" + "\n" +
                "Employee Name : " + getName() + "\n" +
                "Employee ID : " + getId() + "\n" +
                "Email : " + getEmail() + "\n" +
                "Salary : " + salary + "\n" +
                "Working Time (hrs) : " + workingTime + "\n" +
                "Overtime (hrs) : " + overTime + "\n" +
                "-------------------------" + "\n";
    }

    public static void totalNumberOfUniqueEmployees() {
        System.out.println("Total Number Of Unique Employees : " + employeeCounter);
    }
}