package lesson1;

import java.util.Scanner;

public class Lesson1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char char_vareable = 'a';
        byte byte_vareable = 6;
        short short_vareable = 569;
        int int_vareable = 55423542;
        long long_vareable = 153748633545685746L;
        float float_vareable = 512.1f;
        double double_vareable = 34536677.5;
        boolean boolean_vareable = true;

        menu();
    }

    static void menu() {

        System.out.println("1. Вычислить выражение  a * (b + (c / d))");
        System.out.println("2. Лежит ли сумма двух чисел в пределах от 10 до 20(включительно)");
        System.out.println("3. Положительное или отрицательное число ввел пользователь");
        System.out.println("4. Отрицательное ли число");
        System.out.println("5. Вывести сообщение «Привет, указанное_имя!»");
        System.out.println("6. Определяет является ли год високосным");
        System.out.println("0. Выход");
        int select_item = scanner.nextInt();
        System.out.println();

        switch (select_item) {
            case 1:
                formulCalc();
                break;
            case 2:
                numbersSumm();
                break;
            case 3:
                positiveOrNegative();
                break;
            case 4:
                negativeNumber();
                break;
            case 5:
                helloName();
                break;
            case 6:
                leapYear();
                break;
            case 0:
                return;
            default:
                System.out.println("Нет такого пункта меню!\n");
                break;
        }
        System.out.println();
        menu();
    }

    static void formulCalc() {
        System.out.print("Введите число а = ");
        int a = scanner.nextInt();
        System.out.print("Введите число b = ");
        int b = scanner.nextInt();
        System.out.print("Введите число c = ");
        int c = scanner.nextInt();
        System.out.print("Введите число d = ");
        int d = scanner.nextInt();
        System.out.println("a * (b + (c / d)) = " + calculateExpression(a, b, c, d));

    }

    static float calculateExpression(int a, int b, int c, int d) {
        return a * (b + (c / (float) d));
    }

    static void numbersSumm() {
        System.out.print("Введите число а = ");
        float a = scanner.nextFloat();
        System.out.print("Введите число b = ");
        float b = scanner.nextFloat();
        System.out.println("Лежит в пределах от 10 до 20 " + isGapBelong(a, b));
    }

    static boolean isGapBelong(float a, float b) {
        float c = a + b;
        return c > 10 && c <= 20;
    }

    static void positiveOrNegative() {
        System.out.print("Введите число = ");
        int a = scanner.nextInt();
        System.out.println("Ваше число " + signumNumber(a));

    }

    static String signumNumber(int a) {
        return a < 0 ? "отричательное" : "положительное";
    }

    static void negativeNumber() {
        System.out.print("Введите число = ");
        int a = scanner.nextInt();
        System.out.println("Отричательное число? " + isNegativeNumber(a));
    }

    static boolean isNegativeNumber(int a) {
        return a < 0;
    }

    static void helloName() {
        System.out.print("Введите имя ");
        String a = scanner.next();
        System.out.println("Привет, " + a);
    }

    static void leapYear() {
        System.out.print("Введите год ");
        int a = scanner.nextInt();
        if (a > 0) {
            if ((a % 400 == 0) || (a % 4 == 0 && a % 100 != 0)) System.out.println("Високосный год");
            else
                System.out.println("Не високосный год");
        } else {
            System.out.println("Неверный ввод");
            leapYear();
        }
    }
}
