package DefiningClasses.CompanyRoaster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public double getSalary() { return this.salary; }

    public String getName() { return this.name; }

    public String getEmail() { return this.email; }

    public int getAge() { return this.age; }

    public void setEmail (String email) { this.email = email; }

    public void setAge(int age) { this.age = age; }
}
