package kaoshi;
class Employee{
    String name;
    String employeeId;
    int salary;

    public Employee() {
    }

    public Employee(String name, String employeeId, int salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
class Manager extends Employee{
    int bonus;

    public Manager() {
    }

    public Manager(String name, String employeeId, int salary, int bonus) {
        super(name, employeeId, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
public class Test1 {
    public static void main(String[] args) {

    }
}
