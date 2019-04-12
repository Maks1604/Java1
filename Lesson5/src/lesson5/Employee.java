package lesson5;

public class Employee {

    private String FIO;
    private String Position;
    private String e_mail;
    private String phone;
    private int Salary;
    private int Age;

    public Employee(String FIO, String position, String e_mail, String phone, int salary, int age) {
        this.FIO = FIO;
        Position = position;
        this.e_mail = e_mail;
        this.phone = phone;
        Salary = salary;
        Age = age;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "FIO='" + FIO + '\'' +
                ", Position='" + Position + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", phone='" + phone + '\'' +
                ", Salary=" + Salary +
                ", Age=" + Age +
                '}';
    }

    public void showConsole() {
        System.out.println(toString());
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

}
