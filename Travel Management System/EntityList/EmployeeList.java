package EntityList;
import Entities.Employee;

public class EmployeeList {
    private Employee[] employees;

    public EmployeeList() {
        employees = new Employee[5];
    }

    public EmployeeList(int size) {
        employees = new Employee[size];
    }

    public void insert(Employee e) {
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = e;
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Insertion Successful.");
        } else {
            System.out.println("Insertion Failed.");
        }
    }

    public Employee getById(String id) {
        boolean flag = false;
        Employee e = null;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeId().equals(id)) {
                    e = employees[i];
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("Employee Found.");
        } else {
            System.out.println("No Employee Found With This ID.");
        }

        return e;
    }

    public void removeById(String id) {
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeId().equals(id)) {
                    employees[i] = null;
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("Removal Successful.");
        } else {
            System.out.println("Removal Failed.");
        }
    }

    public void update(String id, Employee updatedEmployee) {
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeId().equals(id)) {
                    employees[i] = updatedEmployee;
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("Update Successful.");
        } else {
            System.out.println("Update Failed.");
        }
    }

    public void showAll() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].showEmployeeInfo();
            }
        }
    }

    public String getAllAsString() {
        String allEmployees = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                allEmployees += employees[i].getEmployeeAsString() + "\n";
            }
        }
        return allEmployees;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }
}