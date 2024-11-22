public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;

        department.addEmployee(this);

    }

    public String getName() {
        return name;
    }

    public boolean isChief() {
        return department != null && department.getChief() == this;
    }

    public String toString() {
        if(isChief()) {
            return name + " начальник отдела " + department;
        }
        return name + " работает в отделе " + department + ", начальник которого " + department.getChief().getName();
    }
}
