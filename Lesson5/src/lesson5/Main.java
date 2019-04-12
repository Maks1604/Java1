package lesson5;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Employee[] employeeArray = readEmployees();
        WriteEmployeeForAge(employeeArray);
    }

    public static Employee[] readEmployees() {
        System.out.println("Введите введите количество ввода сотрудников ");
        int countEmployee = scanner.nextInt();
        Employee[] employeeArray = new Employee[countEmployee];
        for (int i = 0; i < countEmployee; i++) {
            employeeArray[i] = readEmployee();
        }
        return employeeArray;
    }

    public static void WriteEmployeeForAge(Employee[] employees) {
        System.out.println("Введите минимальный возраст сотрудника");
        int age = scanner.nextInt();
        for (Employee employee : employees) {
            if (employee.getAge() >= age) {
                employee.showConsole();
            }

        }
    }

    public static Employee readEmployee() {

        Employee employee = new Employee();
        System.out.println("Введите Фамилию Имя Отчество сотрубника");
        employee.setFIO(scanner.next());
        System.out.println("Введите Должность сотрудника");
        employee.setPosition(scanner.next());
        System.out.println("Введите e-mail сотрудника");
        employee.setE_mail(scanner.next());
        System.out.println("Введите Номер телефона сотрудника");
        employee.setPhone(scanner.next());
        System.out.println("Введите Зарплату сотрудника");
        employee.setSalary(scanner.nextInt());
        System.out.println("Введите Возраст сотрудника");
        employee.setAge(scanner.nextInt());
        System.out.println();
        return employee;
    }
}
