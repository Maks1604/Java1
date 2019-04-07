package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static boolean isStartGame;

    public static void main(String[] args) {
        isStartGame = false;
        menu();




    }

    static void menu() {
        if (isStartGame) {
            System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет");
            int menuPoint = scanner.nextInt();

            switch (menuPoint) {
                case 1:
                    compareNumbers();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Вы ввели не правильно");
                    break;
            }

        } else {
            isStartGame = true;
            compareNumbers();
        }
        menu();
    }


    static void compareNumbers() {
        int number = random.nextInt(10);

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите число от 0 до 10");
            int scannerNumber = scanner.nextInt();

            if (number == scannerNumber) {
                System.out.println("Вы угадали");
                return;
            } else {
                String bigOrSmall = scannerNumber > number ? "больше" : "меньше";
                System.out.println("Вы ввели число " + bigOrSmall + " загадонного");
            }
        }

        System.out.println("Попытки закончились");
    }

}
