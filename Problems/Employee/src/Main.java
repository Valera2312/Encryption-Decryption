class Employee {

    String name;
    int salary;
    String address;

    public Employee() {
        this.name = "unknown";
        this.address = "unknown";
        this.salary = 0;
    }
    public Employee(String name, int salary) {
        this.salary = salary;
        this.name = name;
        this.address = "unknown";
    }
    public Employee(String name, int salary, String address) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }
}