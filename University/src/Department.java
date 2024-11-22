import java.util.ArrayList;

public class Department {
    private String name;
    private Employee chief;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.chief = null;
        this.employees = new ArrayList<Employee>();
    }

    public Employee getChief() {
        return chief;
    }

    public void setChief(Employee chief) {
        this.chief = chief;
    }

    public String toString() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void printEmployees() {
        System.out.println("Список всех сотрудников: ");
        for(Employee employee: employees) {
            System.out.println(employee.getName());
        }
    }
}
